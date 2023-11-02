package creationalDesignPatterns.singletonPattern.destroyViaClone;

public class ClientTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        /*
            we are creating singleton2 using clone so hashcode will be different.
        */

        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = (SingletonLazy) singletonLazy1.clone();

        boolean isSingletonLazy = String.valueOf(singletonLazy1.hashCode()).equals(String.valueOf(singletonLazy2.hashCode()));
        System.out.println(singletonLazy1.hashCode() + " " + singletonLazy2.hashCode() + " " + isSingletonLazy);

    }
}
