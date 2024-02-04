package future_callable;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        //Callable is like Runnable but it returns value
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            System.out.println("Callable is like Runnable but it returns value");
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> future = executorService.submit(task);

        try {
            //future.get() returns only when the result is available
            Integer result = future.get();
            Integer result1 = future.get(100, TimeUnit.MILLISECONDS);
            System.out.println("result " + result);
            System.out.println("result1 " + result1);
        } catch ( InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        List<Integer> numbers = List.of(1,2,3,400);

        //FACTORIAL USING MULTIPLE THREADS & CALLABLE & FUTURE & BIG INTEGER
        ExecutorService executorService_1 = Executors.newFixedThreadPool(2);
        List<Future<Map.Entry<Integer, BigInteger>>> futures = new ArrayList<>();
        for (Integer number: numbers){
            futures.add(executorService_1.submit(new FactorialTask(number)));
        }
        Map<Integer, BigInteger> results = new HashMap<>();
        for (Future<Map.Entry<Integer, BigInteger>> future_1: futures){
            try {
                Map.Entry<Integer, BigInteger> result = future_1.get();
                results.put(result.getKey(), result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService_1.shutdown();



    }
}
