package future_callable;

import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Map.Entry<Integer, BigInteger>> {

    private final Integer number;

    public FactorialTask(Integer number) {
        this.number = number;
    }

    @Override
    public Map.Entry<Integer, BigInteger> call() throws Exception {
        BigInteger factorial = BigInteger.ONE;
        for (int i =0; i < number; i++){
            factorial =  factorial.multiply(BigInteger.valueOf(i));
        }
        return new AbstractMap.SimpleEntry<>(number , factorial);
    }
}
