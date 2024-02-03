package streams_lamdas_methodreference;

import comparable_vs_comparator.StudentComparable;
import comparable_vs_comparator.StudentComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //lamda expression is a short, anonymous func that can be used to implement funtional interface (has only 1 abstract method inside)

        //Predicate is built in functional interface that takes an argument & returns a boolean
        Predicate<String> check_larger_than_5 = s -> s.length() > 5;
        boolean result = check_larger_than_5.test("Sahil");
        System.out.println(result);

        //Consumer is built in functional interface that takes a parameter and returns nothing
        Consumer<String> print_upper_case = x -> System.out.println(x.toUpperCase());
        print_upper_case.accept("give here input string");

        predicateAsFunctionParameter(check_larger_than_5);
        predicateAsFunctionParameter(o -> o.startsWith("a"));

        // method reference - when we use lamda expression to trigger another existing method, we can write in short syntax.
        // can be used for existing methods
        Consumer<String> p = s -> s.toUpperCase() ;
        Consumer<String> p1 = String::toUpperCase;

        // Stream API allow to process & manipulate datasets using func programming approach
        // Stream is sequence of elements that can be processed sequentially or parallelly
        // Stream can be created from Collections, arrays, I/o channels
        // intermediate operations(filter, map, flatMap): chainable, return new version of stream, are LAZY i.e. they don't execute until terminal op is called
        // terminal operations(forEach, collect, reduce): end stream, no other operation allowed

        List<String> list = Arrays.asList("a", "b", "sahil", "kunjan", "ritwik", "aditya");
        Stream<String> stream = list.stream();

        int[] arr = {3, 2, 5};
        //ERROR Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> stream1 = Arrays.stream(arr).boxed();
        // Stream<Integer> stream2 = (Stream<Integer>) Arrays.stream(arr);
        // ERROR IntStream stream3 = Arrays.stream(arr);

        Stream<Integer> stream4 = Stream.of(1, 2, 3);

        List<String> filtered_names = stream
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(filtered_names);


        // FIND highest score for a subject in Student obj
        List<Student> students = Arrays.asList(
                new Student("Sahil", "CS", Map.of("Algo", 90, "DS" , 80, "Security", 75)),
                new Student("Aditya", "Mathematics", Map.of("Algo", 70, "DS" , 60, "Security", 65)),
                new Student("Ritwik", "CS", Map.of("Algo", 91, "DS" , 68, "Security", 85)),
                new Student("Kunjan", "Mathematics", Map.of("Algo", 79, "DS" , 90, "Security", 95))
        );
        String subject = "CS";
        int maxGrade = find_max_grade(students, subject);
        System.out.println(maxGrade);

    }

    static int find_max_grade(List<Student> students, String subject) {
        return students.stream()
                .filter(s -> s.getSubject().equals(subject))
                .flatMap(s -> s.getGrades().values().stream())
                .max(Integer::compareTo).orElseGet(() -> 0);
    }

    public static void predicateAsFunctionParameter (Predicate<String> predicate) {
        System.out.println(predicate.test("abcd"));
    }
}
