package concurrency_multithreading;

public class MyCustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread #" + Thread.currentThread().getId());
    }

}
