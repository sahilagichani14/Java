package collections_generics;

public class CustomType <T> {
    private T customvar;

    public CustomType(T customvar) {
        this.customvar = customvar;
    }

    public T getCustomvar(){
        return this.customvar;
    }

    public void setCustomvar(T customvar){
        this.customvar = customvar;
    }

    @Override
    public String toString() {
        return "CustomType{" +
                "customvar=" + customvar +
                '}';
    }
}
