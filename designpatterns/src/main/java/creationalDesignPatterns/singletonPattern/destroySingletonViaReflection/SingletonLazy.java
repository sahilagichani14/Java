package creationalDesignPatterns.singletonPattern.destroySingletonViaReflection;

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
