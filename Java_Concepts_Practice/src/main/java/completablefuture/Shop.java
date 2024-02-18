package completablefuture;

import java.util.concurrent.TimeUnit;

public class Shop {

    public String getPrice() {
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Shop price is 1M$";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
