package concurrency_multithreading;

public class MyCustomThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread #" + Thread.currentThread().getId());
    }
}
