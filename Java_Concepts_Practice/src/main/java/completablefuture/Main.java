package completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /* CompletableFuture is used for asynchronous programming in Java i.e writing non-blocking code by running a task on a
           separate thread rather than the main application thread, so main thread is able to execute other tasks in parallel

           Old Future class Limitations:
           1. Cannot be completed manually: if remote service is down, we can't complete future manually using latest cached
              version of data available
           2. Cannot perform further action until result is available & doesn't notify us if its completion
           3. Cannot attach a callback func & call it automatically when future result is available
           4. Cannot be chained together: when we need to execute long-running task & when task is done we need to pass result
              to another long-running task
           5. Cannot be chained together: suppose we have 10 diff futures running in parallel & then we want to run some func
              after all of them completes
           6. No exception handling
        */

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        //System.out.println(completableFuture.get());  //this will block the thread
        completableFuture.complete("Completed manually");
        System.out.println(completableFuture.get()); // all subsequent calls to the complete method will be ignored
        System.out.println(completableFuture.get());

        CompletableFuture<String> completableFuture_1 = new CompletableFuture<>();
        System.out.println(completableFuture_1.getNow("Give default value if result is not ready"));
        completableFuture_1.complete("Completed manually");
        System.out.println(completableFuture_1.get()); // all subsequent calls to the complete method will be ignored

        // To run some task asynchronously without return use runAsync() method
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> completableFuture_2 = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Main Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        completableFuture_2.get();

        // To run some task asynchronously with return use supplyAsync() method
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<String> completableFuture_3 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                return "Main Thread: " + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        completableFuture_3.get();


        // We can attach callback to CompletableFuture which should automatically get called when future completes using thenApply, thenAccept, thenRun
        // thenApply used when we want to chain since it returns a val, unlike thenAccept, thenRun
        CompletableFuture<String> completableFuture_4 = CompletableFuture.supplyAsync(()-> "1st Task ")
                .thenApply(supplyResult -> supplyResult + "2nd Task ")
                .thenApply(supplyResult -> supplyResult + "3rd Task ");
        System.out.println(completableFuture_4.get());

        // if we want to run the tasks in diff thread use thenApplyAsync
        CompletableFuture<String> completableFuture_5 = CompletableFuture.supplyAsync(()-> "1st Task by " + Thread.currentThread().getName())
                .thenApplyAsync(supplyResult -> supplyResult + "2nd Task by " + Thread.currentThread().getName())
                .thenApplyAsync(supplyResult -> supplyResult + "3rd Task by " + Thread.currentThread().getName());
        System.out.println(completableFuture_5.get());

        //thenAccept Doesn't return anything so Void
        Void completableFuture_6 = CompletableFuture.supplyAsync(()-> "1st Task!!! ")
                .thenApply(supplyResult -> supplyResult + "2nd Task!!! ")
                .thenAccept(supplyResult -> System.out.println(supplyResult + " 3rd Task!!!"))
                .get();

        // thenRun doesn't have access to previous future result & doesn't return anything
        CompletableFuture.supplyAsync(()-> "1st!!! ")
                .thenApply(supplyResult -> supplyResult + "2nd!!!")
                .thenRun(()-> System.out.println("3rd Independent Task"))
                .get();


        CompletableFuture<CompletableFuture<String>> result = getBankAccount("accId")
                .thenApply(account -> getAccountBalance("account"));
        //thenCompose
        CompletableFuture<String> sameResultButFlattened = getBankAccount("accId")
                .thenCompose(account -> getAccountBalance("account"));

        //thenCombine - run 2 future independently & perform task after both are received
        CompletableFuture<Double> positiveFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("Retrieve +ve number");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 33.0;
        });

        CompletableFuture<Double> negativeFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("Retrieve -ve number");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return -93.0;
        });
        CompletableFuture<Double> combinedFuture = positiveFuture.thenCombine(
                negativeFuture, (positiveVal, negativeVal) -> positiveVal - negativeVal);
        System.out.println(combinedFuture.get());

        List<String> myList = new ArrayList<>();
        CompletableFuture<String> completableFuture_7 = CompletableFuture.supplyAsync(()->{
            if (myList.isEmpty()){
                throw new IllegalArgumentException("List is empty");
            }
            //do something
            return "List processed Successfully";
        }).exceptionally(exception -> {
            return "Exception occured"+ exception.getMessage();
        });
        System.out.println("Result " + completableFuture_7.get());

        List<String> myList1 = new ArrayList<>();
        CompletableFuture<String> completableFuture_8 = CompletableFuture.supplyAsync(()->{
            if (myList.isEmpty()){
                throw new IllegalArgumentException("List is empty");
            }
            //do something
            return "List processed Successfully";
        }).handle((res, exception) -> {
            if (exception==null) return res;
            return "Exception occured"+ exception.getMessage();
        });
        System.out.println("Result " + completableFuture_8.get());
    }

    public static CompletableFuture<String> getBankAccount(String accId) {
        return CompletableFuture.supplyAsync(() -> "AccountService.getBankAccount(accId) assume " +
                "this func is called & returns a BankAccount obj instead of String");
    }

    public static CompletableFuture<String> getAccountBalance(String bankAccount) {
        return CompletableFuture.supplyAsync(()->"BalanceService.getAccountBalance(bankAccount) assume " +
                "this func is called & returns a Double obj instead of String & takes BankAccount obj as parameter");
    }

}
