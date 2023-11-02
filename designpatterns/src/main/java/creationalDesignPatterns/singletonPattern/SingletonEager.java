package creationalDesignPatterns.singletonPattern;

/*  Ensures that only 1 instance of the class exists in the JVM
    Make sure that singleton class must provide a global access point to get an instance
*/

/*  https://kkjavatutorials.com/design-pattern/
    Steps to create Singleton Pattern:
    1. create a private constructor to restrict instantiation of the class from other classes
    2. create private static variable of the same class that is the only instance of the class
    3. create a public static method that returns the instance of class & this is the global access point for outer world to
       get instance of the singleton class
*/

/*  Eager Loading since static var INSTANCE gets instantiated at the time of class Loading
    Disadvantage:
    1. instance created even if client application might not be using it, use this only if your singleton class is not using
       lot of resources. But mostly singleton classes are created for file system or DB connection so avoid eager.
    2. doesn't handle exception handling as INSTANCE is not under try catch so instantiate inside try catch.
*/

public class SingletonEager {

    //private static final SingletonEager INSTANCE = new SingletonEager();
    private static SingletonEager INSTANCE = null;

    static {
        try {
            if (INSTANCE == null){
                INSTANCE = new SingletonEager();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private SingletonEager(){

    }

    public static SingletonEager getInstance(){
        return INSTANCE;
    }

}
