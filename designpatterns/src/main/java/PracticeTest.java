import java.util.stream.Stream;

class Parent {
    public static void m1(){
        System.out.println("Parent m1");
    }
    private void m2(){}
}

class Child extends Parent {
    public static void m1(){
        System.out.println("Child m1");
    }
    private void m2(){}
}

public class PracticeTest {

    public static void main(String[] args) {
        Stream.of(1,1,2,3,5).peek(System.out::println).filter(x->x==8).count();

        Parent p = new Child();
        p.m1();

    }
}
