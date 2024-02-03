package collections_generics;

public class Pair <T, K>{
    private T firstgeneric;
    private K secondgeneric;

    public Pair(T firstgeneric, K secondgeneric) {
        this.firstgeneric = firstgeneric;
        this.secondgeneric = secondgeneric;
    }

    public T getFirstgeneric() {
        return firstgeneric;
    }

    public void setFirstgeneric(T firstgeneric) {
        this.firstgeneric = firstgeneric;
    }

    public K getSecondgeneric() {
        return secondgeneric;
    }

    public void setSecondgeneric(K secondgeneric) {
        this.secondgeneric = secondgeneric;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstgeneric=" + firstgeneric +
                ", secondgeneric=" + secondgeneric +
                '}';
    }
}
