package creationalDesignPatterns.singletonPattern.serializedSingleton;

import java.io.Serializable;

public class SingletonLazy implements Serializable {

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

    private Object readResolve(){
        return SingletonLazy.getInstance();
    }

}
