package completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureVsParallelStreams {
    //Both are used for asynchronous computations

    public static List<Shop> getShops(){
        List<Shop> shopList = new ArrayList<>();
        for (int i=0; i<10; i++){
            shopList.add(new Shop());
        }
        return shopList;
    }

    public static List<String> findPriceUsingParallelStream(List<Shop> shopList){
        return shopList.parallelStream().map(Shop::getPrice).collect(Collectors.toList());
    }

    public static List<String> findPriceUsingCompletableFuture(List<Shop> shopList){
        final List<CompletableFuture<String>> shopsFuture = shopList.
                stream().map(shop -> CompletableFuture.supplyAsync(shop::getPrice)).collect(Collectors.toList());

        final List<String> shopPrices = shopsFuture.stream()
                .map(CompletableFuture::join).collect(Collectors.toList()); //wait for all async tasks to complete
        return shopPrices;
    }

    public static List<String> findPriceUsingCompletableFutureWithCustomExecutors(List<Shop> shopList){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final List<CompletableFuture<String>> shopsFuture = shopList.
                stream().map(shop -> CompletableFuture.supplyAsync(shop::getPrice, executorService)).collect(Collectors.toList());

        final List<String> shopPrices = shopsFuture.stream()
                .map(CompletableFuture::join).collect(Collectors.toList()); //wait for all async tasks to complete

        executorService.shutdown();
        return shopPrices;
    }

}
