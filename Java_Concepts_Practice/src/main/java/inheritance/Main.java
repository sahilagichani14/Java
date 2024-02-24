package inheritance;

//class name and filename can be diff but its easier to run this via IDE only
class A{
    int p=19;

    // can write static public as well
    static public void main(String[] args){
        System.out.println("Run");

        A a = new A();
        a.getA();
        // a.getB(); not allowed
        // System.out.println(a.x);
        System.out.println(a.p);
        System.out.println("========================");

        A a1 = new B(10);
        a1.getA(); // overriden method in B class called TRICKY PART
        // a1.getB();
        // System.out.println(a1.x);
        System.out.println(a1.p);
        System.out.println("========================");

        B b1 = new B(40);
        System.out.println(b1.x);
        System.out.println(b1.p);
        b1.getA(); // overriden method in B class called
        b1.getB();


    }
    void getA(){
        System.out.println("A getA");
    }
}

class B extends A{
    int x=0;
    B(int y){
        this.x = y;
    }

    void getB(){
        System.out.println("B");
    }

    void getA(){
        System.out.println("B getA");
    }
}