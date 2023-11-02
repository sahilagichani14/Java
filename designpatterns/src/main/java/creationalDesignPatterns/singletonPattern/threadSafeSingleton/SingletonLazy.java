package creationalDesignPatterns.singletonPattern.threadSafeSingleton;

public class SingletonLazy {

    private static SingletonLazy INSTANCE = null;

    private SingletonLazy(){

    }

    //make method as synchronized, since it is on static it means it is on class level lock ie only 1 thread allowed at a time.
//    public static synchronized SingletonLazy getInstance() {
//        if (INSTANCE == null) {
//            try {
//                Thread.sleep(2000);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            INSTANCE = new SingletonLazy();
//        }
//        return INSTANCE;
//    }


    /* we use double checking for INSTANCE == null, & use synchronized (SingletonLazy.class) block, instead of putting on method
       for better performance */
    public static SingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonLazy.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE = new SingletonLazy();
                }
            }
        }
        return INSTANCE;
    }

}
