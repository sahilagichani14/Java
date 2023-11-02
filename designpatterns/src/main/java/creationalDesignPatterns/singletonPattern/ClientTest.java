package creationalDesignPatterns.singletonPattern;

public class ClientTest {
    public static void main(String[] args) {

        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();

        boolean isSingleton = String.valueOf(singletonEager1.hashCode()).equals(String.valueOf(singletonEager2.hashCode()));
        System.out.println(singletonEager1.hashCode() + " " + singletonEager2.hashCode() + " " + isSingleton);

        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();

        boolean isSingletonLazy = String.valueOf(singletonLazy1.hashCode()).equals(String.valueOf(singletonLazy2.hashCode()));
        System.out.println(singletonLazy1.hashCode() + " " + singletonLazy2.hashCode() + " " + isSingletonLazy);
    }
}
