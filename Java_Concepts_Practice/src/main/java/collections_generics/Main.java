package collections_generics;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Pair<Double, Integer>(40.22, 20));
        System.out.println(new Pair<String, Integer>("Sahil", 20));
        System.out.println(new Pair<Long, Integer>(20L, 20));

        System.out.println(new Pair<CustomType, Integer>(new CustomType<Integer>(32), 20));
        System.out.println(new Pair<CustomType, Integer>(new CustomType<String>("Custom type"), 20));

    }
}
