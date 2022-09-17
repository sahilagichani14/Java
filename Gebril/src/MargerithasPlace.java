/**
 * A small diner that only offers pizza Margherita.
 */
public class MargerithasPlace implements PizzaRestaurant {

    @Override
    public Pizza deliverPizza(String order) {
        // The chef only needs 15 min. for this pizza (expressed as 15 * 10
        // milliseconds)
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Pizza(26, 5, new String[] { "cheese", "tomato", "basil" }, new int[] { 300, 450, 20 });
    }

    @Override
    public String getName() {
        return "Margherita's Place";
    }

}
