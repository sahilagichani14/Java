package creationalDesignPatterns.singletonPattern.billPughSingleton;

public class SingletonLazy {

    private SingletonLazy(){

    }

    private static class SingletonHolder {
        private static final SingletonLazy INSTANCE = new SingletonLazy();
    }

    public static SingletonLazy getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
