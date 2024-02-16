package Junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(HairSalonParameterResolver.class)
@Execution(ExecutionMode.CONCURRENT) // for parallel execution of tests as defined in junit-platform.prop config file
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) //if we want @BeforeAll as not a static method, without this @ methods should be static
public class HairSalonDependencyInjectionTest {

    @Test
    //@RepeatedTest(5) //repeats test 5 times, used for usually testing endpoints
    @DisplayName("Instead of creating new HairSalon(), use hairSalon as parameter, & ExtendWith HairSalonParameterResolver")
    public void testApplyDiscount(HairSalon hairSalon){
        assumeTrue(hairSalon.getHaircutPrice() == 30);

        int expected = 20;
        int actual = hairSalon.applyDiscount();
        assertEquals(expected, actual);
    }

    @RepeatedTest(5) //repeats test 5 times, used for usually testing endpoints
    @DisplayName("Instead of creating new HairSalon(), use hairSalon as parameter, & ExtendWith HairSalonParameterResolver")
    public void testApplyDiscountRepetitionInfo(HairSalon hairSalon, RepetitionInfo repetitionInfo){
        assumeTrue(hairSalon.getHaircutPrice() == 30);
        int expected = 20;
        int actual = hairSalon.applyDiscount();
        assertEquals(expected, actual);
        System.out.println("Number: " + repetitionInfo.getCurrentRepetition());
    }

}
