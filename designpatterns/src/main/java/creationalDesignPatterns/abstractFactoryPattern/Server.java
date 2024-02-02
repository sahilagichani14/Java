package creationalDesignPatterns.abstractFactoryPattern;

public class Server implements Computer {

    private String ram;
    private String hdd;
    private String cpu;
    private boolean isGraphicCardEnabled;
    private boolean isBluetoothEnabled;

    public Server(String ram, String hdd, String cpu, boolean isGraphicCardEnabled, boolean isBluetoothEnabled) {
        super();
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
        this.isGraphicCardEnabled = isGraphicCardEnabled;
        this.isBluetoothEnabled = isBluetoothEnabled;
    }

    @Override
    public String ram() {
        return this.ram;
    }

    @Override
    public String hdd() {
        return this.hdd;
    }

    @Override
    public String cpu() {
        return this.cpu;
    }

    @Override
    public boolean isGraphicCardEnabled() {
        return this.isGraphicCardEnabled;
    }

    @Override
    public boolean isBluetoothEnabled() {
        return this.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Server{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", cpu='" + cpu + '\'' +
                ", isGraphicCardEnabled=" + isGraphicCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }
}
