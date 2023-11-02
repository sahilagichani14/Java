package creationalDesignPatterns.singletonPattern.billPughSingleton;

import creationalDesignPatterns.singletonPattern.billPughSingleton.SingletonLazy;

public class ClientTest {
    public static void main(String[] args) {

        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();

        boolean isSingletonLazy = String.valueOf(singletonLazy1.hashCode()).equals(String.valueOf(singletonLazy2.hashCode()));
        System.out.println(singletonLazy1.hashCode() + " " + singletonLazy2.hashCode() + " " + isSingletonLazy);
    }
}
