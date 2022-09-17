/**
 * A restaurant for dishes with mushrooms.
 */
public class FunghiRestaurant implements PizzaRestaurant {

    @Override
    public Pizza deliverPizza(String order) {
        // needs 30 minutes for the order
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("Funghi".equals(order)) {
            return new Pizza(26, 10, new String[] { "champignon", "cheese", "tomato", "oregano" },
                    new int[] { 300, 450, 600, 20 });
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        return "Happy Mushroom";
    }
}