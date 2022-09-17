import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a pizza. It has a diameter (in cm), a price (in €) and
 * it is aware of its ingredients. For each ingredient, it knows the amount on
 * the pizza (in grams). Note that standard ingredients like the dough, oil and
 * salt won't be part of the list if ingredients.
 */
public class Pizza {

    /**
     * The pizza's diameter.
     */
    protected int diameter;
    /**
     * The price of the pizza.
     */
    protected double price;
    /**
     * A mapping from ingredient name to the amount that can be found on the pizza
     * (in grams).
     */
    protected Map<String, Integer> ingredients = new HashMap<>();

    /**
     * Constructor.
     * 
     * @param diameter          The pizza's diameter.
     * @param price             The price of the pizza.
     * @param ingredientNames   The names of the ingredients of the pizza
     * @param ingredientAmounts The weight of the ingredients (in grams) in the same
     *                          order as the ingredientNames, i.e.,
     *                          ingredientAmounts[0] is the amount of
     *                          ingredientNames[0].
     */
    public Pizza(int diameter, int price, String[] ingredientNames, int[] ingredientAmounts) {
        this.diameter = diameter;
        this.price = price;
        if (ingredientNames.length != ingredientAmounts.length) {
            throw new IllegalArgumentException("The size of the ingredient arrays are different.");
        }
        for (int i = 0; i < ingredientNames.length; ++i) {
            ingredients.put(ingredientNames[i], ingredientAmounts[i]);
        }
    }

    /**
     * Returns the diameter of the pizza.
     * 
     * @return
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Returns the diameter of the pizza.
     * 
     * @return the diameter of the pizza.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gives the amount of an ingredient (in gram).
     * 
     * @param ingredient
     * @return
     */
    public int getAmountOf(String ingredient) {
        return ingredients.getOrDefault(ingredient, 0);
    }

    /**
     * Returns the map containing the ingrediants and their amounts.
     * 
     * @return the map containing the ingrediants and their amounts.
     */
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
