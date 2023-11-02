package creationalDesignPatterns.singletonPattern.destroyViaClone;

public class SingletonLazy implements Cloneable {

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("You cannot create clone of a Singleton!!");
        // return super.clone();
    }
}
