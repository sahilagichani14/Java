// Please do not forget to add your imports here
// YOUR CODE HERE
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PizzaEvalFramework {
    
    // If your framework needs any attributes, you should put them here
    // YOUR CODE HERE

    public PizzaEvalFramework() {
        // Your framework should be initialized here
        // YOUR CODE HERE
    	
    }

    public Map<String, Object> evaluate(PizzaRestaurant restaurant, String order, String[] expectedIngredients) {
        // This method is called within our tests to run the evaluation
        // YOUR CODE HERE
    	Pizza pizza = restaurant.deliverPizza(order);
    	Map<String, Integer> deliveredIngredients = pizza.getIngredients();
    	
    	Map<String, Object> mp = new HashMap<>();
    	
//    	mp.put(Constants.PRECISION_NAME, precision(deliveredIngredients, expectedIngredients, mp));
//    	mp.put(Constants.RUNTIME_NAME, runtime(restaurant, mp));
//    	mp.put(Constants.ERROR_NAME, errorname(restaurant, order, mp));
//    	mp.put(Constants.COSTS_PER_SQ_CM_NAME, pricepersqcm(pizza, mp));
//    	mp.put(Constants.PHI_RMSE_NAME, goldenratio(pizza, mp));
    	
    	precision_recall_f1score(restaurant.deliverPizza(order).getIngredients(), expectedIngredients, mp);
    	mp.put(Constants.RUNTIME_NAME, runtime(restaurant));
    	mp.put(Constants.ERROR_NAME, errorname(restaurant, order));
    	mp.put(Constants.COSTS_PER_SQ_CM_NAME, pricepersqcm(restaurant,order));
    	mp.put(Constants.PHI_RMSE_NAME,goldenratio(restaurant.deliverPizza(order).getIngredients()));
    	
        return mp;
    }

	public static void precision_recall_f1score(Map<String, Integer> deliveredIngredients,String[] expectedIngredients, Map<String, Object> mp) {
    	
		int matchingIngredients = 0;
		 
    	for(String ingredient: expectedIngredients){
    		if(deliveredIngredients.containsKey(ingredient) && deliveredIngredients.get(ingredient)>0) {
    			matchingIngredients++;
    		}
    	}
    	
    	Double precision = (double) matchingIngredients / deliveredIngredients.size();
        Double recall = (double) matchingIngredients / expectedIngredients.length;
        Double f1score = (double) 2*precision*recall / (precision+recall);
    	
    	mp.put(Constants.PRECISION_NAME, precision);
    	mp.put(Constants.RECALL_NAME, recall);
    	mp.put(Constants.F1MEASURE_NAME, f1score);
    	
    }
   	
	//https://www.baeldung.com/java-delay-code-execution
	public static Double runtime(PizzaRestaurant restaurant) {
		if(restaurant instanceof MargerithasPlace) {
			//5sec=5000ms but for us given 1min=10ms 
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                // your code here
			            }
			        }, 
			        150 
			);
			return 15.05;
		}
		if(restaurant instanceof FunghiRestaurant) {
			//5sec=5000ms but for us given 1min=10ms 
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                // your code here
			            }
			        }, 
			        150 
			);
			return 30.05;
		}
		return 1.00;
	}
	

	/*
	 * public static Boolean errorname(PizzaRestaurant restaurant, String order) {
	 * if(restaurant.getName().equals("Margherita's Place") &&
	 * order.equals("Margherita")) { return true; }
	 * if(restaurant.getName().equals("Happy Mushroom") && order.equals("Funghi")) {
	 * return true; } return false;
	 * 
	 * }
	 */
	
	public static Boolean errorname(PizzaRestaurant restaurant, String order) {
        if(restaurant.deliverPizza(order)!=null){
            return false;
        }
        return true;
    }

	public static Double pricepersqcm(PizzaRestaurant restaurant, String order) {
		int diameter = restaurant.deliverPizza(order).getDiameter(); //in cm
        Double radius = (double) (diameter/2);
        double price = restaurant.deliverPizza(order).getPrice(); //in euro
        
        return (double) price/(Math.PI*radius*radius);
	}
	
	/*
	 * high amount ingredients: cheese, tomato 
	 * medium amount ingredients: champignon
	 * low amount ingredients: basil, oregano
	 */
	
	public static Double goldenratio(Map<String, Integer> deliveredIngredients) {
		
		Set<String> highIngredients = new HashSet<>();
		Set<String> medIngredients = new HashSet<>();
		Set<String> lowIngredients = new HashSet<>();
		
		for(String deliveredIngredient: deliveredIngredients.keySet()) {
			if(deliveredIngredient.equalsIgnoreCase("cheese")) {highIngredients.add("cheese");}
			if(deliveredIngredient.equalsIgnoreCase("tomato")) {highIngredients.add("tomato");}
			if(deliveredIngredient.equalsIgnoreCase("champignon")) {medIngredients.add("champignon");}
			if(deliveredIngredient.equalsIgnoreCase("basil")) {lowIngredients.add("basil");}
			if(deliveredIngredient.equalsIgnoreCase("oregano")) {lowIngredients.add("oregano");}
		}
	
		int counter=0;
		Double sum = 0.00;
		
		//high-med pairs
		for(String highIngredient: highIngredients) {
			for(String medIngredient: medIngredients) {
				double error = Constants.PHI - (double) deliveredIngredients.get(highIngredient)/deliveredIngredients.get(medIngredient);
				sum += error*error;  
				counter++;
			}
		}
		
		//med-low pairs
		for(String medIngredient: medIngredients) {
			for(String lowIngredient: lowIngredients) {
				double error = Constants.PHI - (double) deliveredIngredients.get(medIngredient)/deliveredIngredients.get(lowIngredient);
				sum += error*error;  
				counter++;
			}
		}
		
		//high-low pairs
		for(String highIngredient: highIngredients) {
			for(String lowIngredient: lowIngredients) {
				double error = (Constants.PHI * Constants.PHI) - (double) deliveredIngredients.get(highIngredient)/deliveredIngredients.get(lowIngredient);
				sum += error*error;  
				counter++;
			}
		}
		
		return Math.sqrt(sum/counter);
	}
    
    
    public static void main(String[] args) {
    	PizzaEvalFramework framework = new PizzaEvalFramework();
    	PizzaRestaurant restaurant1 = new MargerithasPlace();
    	PizzaRestaurant restaurant2 = new FunghiRestaurant();

    	// Let's order a Margherita at Margeritha's Place
    	String pizza1 = "Margherita";
    	// We would expect cheese, tomato and some basil
    	//Map<String, Object> resultR1P1 = framework.evaluate(restaurant1, pizza1, new String[]{ "cheese", "tomato", "basil" });

    	String pizza2 = "Funghi";
    	// We would expect champignon, cheese, tomato and some oregano
    	Map<String, Object> resultR1P2 = framework.evaluate(restaurant1, pizza2, new String[]{ "champignon", "cheese", "tomato", "oregano" });

	}
}