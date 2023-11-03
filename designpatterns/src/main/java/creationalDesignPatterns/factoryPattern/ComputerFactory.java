package creationalDesignPatterns.factoryPattern;

public class ComputerFactory {

    private ComputerFactory(){

    }

    public static Computer getComputer(ComputerType computerType, String ram, String hdd, String cpu, boolean isGraphicCardEnabled, boolean isBluetoothEnabled){
        switch (computerType){
            case PC -> {
                return new PC(ram, hdd, cpu, isGraphicCardEnabled, isBluetoothEnabled);
            }
            case LAPTOP -> {
                return new Laptop(ram, hdd, cpu, isGraphicCardEnabled, isBluetoothEnabled);
            }
            case SERVER -> {
                return new Server(ram, hdd, cpu, isGraphicCardEnabled, isBluetoothEnabled);
            }
            default -> {
                throw new RuntimeException("Invalid ComputerType");
            }
        }
    }
}
