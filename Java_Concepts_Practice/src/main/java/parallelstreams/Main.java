package parallelstreams;

import completablefuture.CompletableFutureVsParallelStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        /* Parallel Streams meant for utilizing multiple cores of the processor, order or execution is not under our control
        * list.parallelStream() is faster than list.streams().parallel()
        * Parallel is better if we are NOT doing any update or add operation
        * */

        long start=0, end=0;
        // start = System.currentTimeMillis();
        // IntStream.range(1,100).forEach(System.out::print);
        // end = System.currentTimeMillis();
        // System.out.println("Normal Stream time: " + (end-start));

        // IntStream.range(0,100).parallel().forEach(System.out::print);
        // start = System.currentTimeMillis();
        // end = System.currentTimeMillis();
        // System.out.println("Parallel Stream time: " + (end-start));

//        IntStream.range(1,10).forEach(x->{
//            System.out.println("Stream thread: " + Thread.currentThread().getName() + " : " + x);
//        });
//
//        IntStream.range(1,10).parallel().forEach(x->{
//            System.out.println("Parallel Stream thread: " + Thread.currentThread().getName() + " : " + x);
//        });

//        List<Student> students = StudentDB.getStudents();
//        start = System.currentTimeMillis();
//        double stream = students.stream().map(Student::getScore).mapToDouble(i->i).average().getAsDouble();
//        end = System.currentTimeMillis();
//        System.out.println("Parallel Stream time: " + (end-start));
//
//        start = System.currentTimeMillis();
//        double parallelStream = students.stream().parallel().map(Student::getScore).mapToDouble(i->i).average().getAsDouble();
//        end = System.currentTimeMillis();
//        System.out.println("Parallel Stream time: " + (end-start));
//
//        start = System.currentTimeMillis();
//        double parallelStream1 = students.parallelStream().map(Student::getScore).mapToDouble(i->i).average().getAsDouble();
//        end = System.currentTimeMillis();
//        System.out.println("Parallel Stream 1 time: " + (end-start));


        start = System.currentTimeMillis();
        int stream_1 = IntStream.range(1,10000).boxed().collect(Collectors.toList()).stream().reduce(0, (x,y)-> x+y);
        end = System.currentTimeMillis();
        System.out.println("Stream time faster: " + (end-start));

        start = System.currentTimeMillis();
        int parallelstream_1 = IntStream.range(1,10000).boxed().collect(Collectors.toList()).parallelStream().reduce(0, (x, y)-> x+y);
        end = System.currentTimeMillis();
        System.out.println("Parallel Stream is slower: " + (end-start));

    }
}
