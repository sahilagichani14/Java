package Junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class OS_JRE_SpecificTests {

    @Test
    @EnabledOnOs({OS.WINDOWS})
    @Disabled("Temporarily Disabled due to maintenance")
    public void testWindows(){
        System.out.println("Windows test - Gareeb Machine");
    }

    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac(){
        System.out.println("Mac test - Aukat ke bahar");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    public void testJRE17(){
        System.out.println("check pom for version 17, compiled by 17");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_18})
    //@DisabledOnJre({JRE.JAVA_18})
    public void testJRE18(){
        System.out.println("check for SDK's in File > Project Structure > SDK's");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "username", matches = "sahilagichani@gmail.com")
    //@DisabledIfEnvironmentVariable()
    public void testEnvVar(){
        System.out.println("Go to Run Config & check for username env var");
    }

    @Test
    @EnabledIfSystemProperty(named = "OS" , matches = "OS=Windows_NT")
    public void testSyetemProperty(){
        System.out.println("Go to Run Config > Env Var & check for OS in System Env var");
    }

}
