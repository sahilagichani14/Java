package optionals_localvartypeinference;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nameOpt = Optional.of("Sahil");

        if(nameOpt.isPresent() && !nameOpt.isEmpty()){
            System.out.println(nameOpt.get());
        }

        System.out.println(nameOpt.orElse("xx"));
        System.out.println(emptyOpt.orElse("XX"));

        //LOCAL VARIABLE TYPE INFERENCE: use var, we infer type from context
        var orderedItems = List.of("chips", "maggi");
        var total = 40.33;
        total = 30L;
        total = 21;
        // total = "s"; //can't change it to string type
        


    }
}
