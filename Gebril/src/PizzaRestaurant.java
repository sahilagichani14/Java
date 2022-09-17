/**
 * This interface defines the methods that a pizza restaurant offers.
 */
public interface PizzaRestaurant {

    /**
     * Interprets the order and delivers the pizza that fits best to the order.
     * 
     * @param order the order that is sent to the restaurant
     * @return the Pizza that is delivered or {@code null} if no pizza is delivered
     */
    Pizza deliverPizza(String order);

    /**
     * Returns the name of the restaurant.
     * 
     * @return the name of the restaurant.
     */
    String getName();
}
