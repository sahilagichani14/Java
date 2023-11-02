package creationalDesignPatterns.singletonPattern.threadSafeSingleton;

import creationalDesignPatterns.singletonPattern.SingletonLazy;

public class MyThread implements Runnable{

    @Override
    public void run() {
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + singletonLazy.hashCode());
    }
}
