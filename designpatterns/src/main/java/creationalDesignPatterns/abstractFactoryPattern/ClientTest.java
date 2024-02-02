package creationalDesignPatterns.abstractFactoryPattern;

import creationalDesignPatterns.factoryPattern.Computer;
import creationalDesignPatterns.factoryPattern.ComputerFactory;
import creationalDesignPatterns.factoryPattern.ComputerType;

public class ClientTest {
    /*
        Abstract Factory Design Pattern is similar to Factory Design Pattern except that its factory of factories.
        Abstract Factory Design Pattern is another layer of abstraction over factory pattern.
        Its used when we need another layer of abstraction over group of factories.
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
