package creationalDesignPatterns.factoryPattern;

// can be an abstract class or normal class
public interface Computer {
    public abstract String ram();
    public abstract String hdd();
    public abstract String cpu();

    public boolean isGraphicCardEnabled();
    public boolean isBluetoothEnabled();

}
