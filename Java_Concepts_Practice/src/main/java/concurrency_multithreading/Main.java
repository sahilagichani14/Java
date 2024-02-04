package concurrency_multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private int counter = 0;

    public static void main(String[] args) {

        MyCustomThread thread1 = new MyCustomThread();
        thread1.start(); //start method executes run method automatically
        MyCustomThread thread2 = new MyCustomThread();
        thread2.start();


        MyCustomThreadRunnable bullet = new MyCustomThreadRunnable();
        // bullet.run(); -> not a way to run, create thread object & put it inside
        Thread gun = new Thread(bullet);
        gun.start();


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task = () -> System.out.println("Thread " + Thread.currentThread().getId());
        for (int i=0; i<10; i++) {
            executorService.execute(task);
        }
        executorService.shutdown();


        //use ConcurrentHashMap, ConcurrentLinkedQueue so it can be safely manipulated & accessed by multiple threads
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key", "value");
        concurrentHashMap.forEach((k,v) -> System.out.println(k + " " + v));

    }

    // you can't use synchronized block in Main class
    // synchronized {}

    //synchronized method -> allows only 1 thread to use common resources at 1 time
    public synchronized void increment() {
        counter++;
    }
}
