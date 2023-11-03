package creationalDesignPatterns.factoryPattern;

public class ClientTest {
    /*
        Factory Design Pattern is used when we have a super class with multiple sub classes & based on input we need to return
        one of the sub class object.
        It is a way to code for interface instead of implementation.
        Robust, less coupled & easy to extend so we can easily change base class implementation since client program is unaware of it.
        Examples: java.lang.Class.forName(), java.sql.DriverManager.getConnection(),java.lang.Class.newInstance()
    */
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(ComputerType.PC, "32GB", "1TB", "i9", true, true);
        System.out.println(pc + "PC Config");

        Computer laptop = ComputerFactory.getComputer(ComputerType.LAPTOP, "16GB", "1TB", "i9", true, true);
        System.out.println(laptop + "LAPTOP Config");

        Computer server = ComputerFactory.getComputer(ComputerType.SERVER, "64GB", "12TB", "i9", true, true);
        System.out.println(server + "Server Config");
    }
}
