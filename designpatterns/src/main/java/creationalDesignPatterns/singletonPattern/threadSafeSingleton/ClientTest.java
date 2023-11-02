package creationalDesignPatterns.singletonPattern.threadSafeSingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTest {
    public static void main(String[] args) {

        ExecutorService executorService = null;
        MyThread myThread = new MyThread();
        try{
            executorService = Executors.newFixedThreadPool(2);
            executorService.execute(myThread);
            executorService.execute(myThread);
            executorService.execute(myThread);

            //without synchronized method. and after synchronized method hashcode will be same
            //pool-1-thread-2 1653102451
            //pool-1-thread-2 1653102451
            //pool-1-thread-1 104428308

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (executorService != null){
                executorService.shutdown();
            }
        }

    }
}
