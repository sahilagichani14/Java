package inheritance;

public class Child extends Parent{

    @Override
    protected Boolean createParentBoolean() {
        return parentInt < 10;
    }
}
