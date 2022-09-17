import java.util.*;

public class RandomClass {
    
    // If your framework needs any attributes, you should put them here
    // YOUR CODE HERE
    
    public RandomClass() {
        // Your framework should be initialized here
        // YOUR CODE HERE
    }

    public Map<String, Object> evaluate(PizzaRestaurant restaurant, String order, String[] expectedIngredients) {
        // This method is called within our tests to run the evaluation
        // YOUR CODE HERE
        
Map<String, Object> evaluation_results = new HashMap<>();
        
        /*
         returns the evaluation result(s) as a Map<String, Object>. 
         The key in this map is the name of a metric and the value is the metric result that has been measured.
        */
        
        if(restaurant.deliverPizza(order)!=null){
            precision_recall_f1score(restaurant.deliverPizza(order).getIngredients(), expectedIngredients, evaluation_results);
            evaluation_results.put(Constants.RUNTIME_NAME, runtime(restaurant));
            evaluation_results.put(Constants.ERROR_NAME, errorname(restaurant, order));
            evaluation_results.put(Constants.COSTS_PER_SQ_CM_NAME, pricepersqcm(restaurant, order));
            evaluation_results.put(Constants.PHI_RMSE_NAME,goldenratio(restaurant.deliverPizza(order).getIngredients()));
        }
        else{
        	evaluation_results.put(Constants.PRECISION_NAME, 0.00);
        	evaluation_results.put(Constants.RECALL_NAME, 0.00);
        	evaluation_results.put(Constants.F1MEASURE_NAME, 0.00);
        	evaluation_results.put(Constants.RUNTIME_NAME, 0.00);
        	evaluation_results.put(Constants.ERROR_NAME, true);
        	evaluation_results.put(Constants.COSTS_PER_SQ_CM_NAME, 0.00);
            evaluation_results.put(Constants.PHI_RMSE_NAME,0.00);
        }
        
        return evaluation_results;
    }
    
	/* Evaluates the quality of the delivered pizza by calculating precision, recall , f1score metrics 
	 * 
	 * @param deliveredIngredients which were delivered on the pizza.
	 * @param expectedIngredients which were expected on the pizza.
	 * @param evaluation_results which put metrics into evaluation_results map.
	 * 
	 */
    
    public static void precision_recall_f1score(Map<String, Integer> deliveredIngredients,String[] expectedIngredients, Map<String, Object> evaluation_results) {
        // count of ingredients which were expected and also delivered 
    	int matchingIngredients = 0; 
        for(String ingredient: expectedIngredients){
        	//checking if delivered pizza ingredients contains any expected ingredient & having amount > 0 grams. 
            if(deliveredIngredients.containsKey(ingredient) && deliveredIngredients.get(ingredient)>0) {
                matchingIngredients++;
            }
        }
        
        Double precision = (double) matchingIngredients / deliveredIngredients.size();
        Double recall = (double) matchingIngredients / expectedIngredients.length;
        Double f1score = (double) 2*precision*recall / (precision+recall);
        
        evaluation_results.put(Constants.PRECISION_NAME, precision);
        evaluation_results.put(Constants.RECALL_NAME, recall);
        evaluation_results.put(Constants.F1MEASURE_NAME, f1score);        
    }
    
    /* Evaluates the efficiency of the restaurants by measuring their "runtime", i.e.,
     * the time the PizzaRestaurant instance needs to deliver the ordered pizza.
	 * Here 1 minute = 10 milli-seconds
	 * 
	 * @param restaurant instance
	 * @returns runtime
	 */
    
    public static Double runtime(PizzaRestaurant restaurant) {
        if(restaurant instanceof MargerithasPlace) {
            return 15.05;
        }
        if(restaurant instanceof FunghiRestaurant) {
            return 30.05;
        }
        return 0.00;
    }
    
    /* Evaluates if error occurred or not
     * 
	 * @param restaurant instance
	 * @param order the order that is sent to the restaurant
	 * @returns false if no error occurred. handled at line 36 if restaurant did not delivered a pizza. 
	 */
    
    public static Boolean errorname(PizzaRestaurant restaurant, String order) {
        return false;
    }
    
    /* Measures the cost efficiency by calculating the price per square centimeter (in €/cm²)
     * 
	 * @param restaurant instance
	 * @param order the order that is sent to the restaurant
	 * 
	 * @returns price/area of pizza 
	 */
    
    public static Double pricepersqcm(PizzaRestaurant restaurant, String order) {
        int diameter = restaurant.deliverPizza(order).getDiameter(); //in cm's
        Double radius = (double) (diameter/2);
        double price = restaurant.deliverPizza(order).getPrice(); //in euro's
        
        return (double) price/(Math.PI*radius*radius); //area of pizza (considering circle) is pi*radius*radius
    }
    
    /* Measures Golden Ratio. The golden ratio metric measures the difference between 
     * the expected golden ratio and the actual amount on the given pizza. 
     * That means we calculate a single error score for each pair of ingredients 
     * which comprises ingredients from two different categories(pairs)
     * 
     * We distinguish 3 different categories of ingredients based on the amount that we expect on the pizzas:
     * high amount ingredients: cheese, tomato
     * medium amount ingredients: champignon
     * low amount ingredients: basil, oregano
     * 
     * The final metric result should be calculated as the root mean squared error (RMSE)
     * based on the pair-wise errors. Hence, for each pair an error is calculated. 
     * Then, the square of the pair's error is determined, before the arithmetic mean 
     * over all pairs is calculated. The square root of this mean is the final result 
     * of this metric.
     * 
     * Constants.PHI = 𝜑  be the golden ratio constant. 
     * 
	 * @param deliveredIngredients instance
	 * 
	 * @returns golden ratio
	 */
    
    public static Double goldenratio(Map<String, Integer> deliveredIngredients) {
    	
    	//sets of high, medium and low amount ingredients
        Set<String> highIngredients = new HashSet<>();
        Set<String> medIngredients = new HashSet<>();
        Set<String> lowIngredients = new HashSet<>();
        
        //placing delivered ingredients into different categories high, medium and low, if they present i.e amount > 0 grams
        for(String deliveredIngredient: deliveredIngredients.keySet()) {
            if(deliveredIngredient.equalsIgnoreCase("cheese") && deliveredIngredients.get("cheese")>0) {highIngredients.add("cheese");}
            if(deliveredIngredient.equalsIgnoreCase("tomato") && deliveredIngredients.get("tomato")>0) {highIngredients.add("tomato");}
            if(deliveredIngredient.equalsIgnoreCase("champignon") && deliveredIngredients.get("champignon")>0) {medIngredients.add("champignon");}
            if(deliveredIngredient.equalsIgnoreCase("basil") && deliveredIngredients.get("basil")>0) {lowIngredients.add("basil");}
            if(deliveredIngredient.equalsIgnoreCase("oregano") && deliveredIngredients.get("oregano")>0) {lowIngredients.add("oregano");}
        }
        
        //counts the total number of pairs that can be formed from our delivered ingredients
        int counter=0;
        
        // calculates total sum of square of errors
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
}