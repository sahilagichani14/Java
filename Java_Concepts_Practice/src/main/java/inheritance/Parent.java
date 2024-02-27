package inheritance;

public abstract class Parent {
    protected static Integer parentInt;
    private void doSomething(){
        createParentBoolean();
    }
    protected abstract Boolean createParentBoolean();
}
