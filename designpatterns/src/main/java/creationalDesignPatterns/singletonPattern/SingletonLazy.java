package creationalDesignPatterns.singletonPattern;

/*  Lazy Initialisation since static var INSTANCE gets instantiated at the time of method calling
    Disadvantage:
    1. Not good for multi thread application as multiple thread can be inside if condition & create multiple instance
*/

public class SingletonLazy {

    private static SingletonLazy INSTANCE = null;

    private SingletonLazy(){

    }

    public static SingletonLazy getInstance(){
        try {
            if (INSTANCE == null){
                INSTANCE = new SingletonLazy();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return INSTANCE;
    }

}
