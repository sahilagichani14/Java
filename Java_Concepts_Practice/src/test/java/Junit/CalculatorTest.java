package Junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    HairSalon hairSalon = new HairSalon();

    @ParameterizedTest
    @MethodSource("getTwoVal")
    public void testSum(int a, int b){
        int expected = 13;
        int actual = calculator.sum(a,b);
        assertEquals(expected, actual);
    }

    //must be static & return type must be Stream<Arguments>
    public static Stream<Arguments> getTwoVal() {
        return Stream.of(
                Arguments.of(11, 2),
                Arguments.of(5, 8)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,55,22})
    //@EnumSource(value = Enum.class, names = {})
    public void testIsEven(int num){
        //boolean expected = true;
        boolean actual = calculator.isEven(num);
        //boolean actual1 = calculator.isEven(9);
        assertTrue(actual);
        //assertFalse(actual1);
    }

    @Test
    public void testIncrementArray(){
        int[] expected = new int[]{2,3,4};
        //int[] expected1 = {1,2,3};
        int[] actual = calculator.incrementArray(new int[]{1, 2, 3});
        //assertEquals(expected, actual); //This will fail as it doesn't check contents of array
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDivideByZero(){
        //it will fail if we don't throw IllegalArgumentException, as normally it throws ArithmeticException
        assertThrows(IllegalArgumentException.class, ()->calculator.divide(1,0));
        // Exception class is the Topmost class so it will pass
        assertThrows(Exception.class, ()->calculator.divide(1,0));
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.divide(1,0));
        String expected = "Int can't be divided by 0";
        String actual = exception.getMessage();
        //assertEquals(expected, actual);
    }

    @Test
    public void checkAssertEquals(){
        List<Integer> expectedList = List.of(1,2,3);
        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.addAll(expectedList);
        LinkedList<Integer> expectedLinkedList = new LinkedList<>(expectedList);

        List<Integer> actualList = List.of(1,2,3);
        Stack<Integer> actualStack = new Stack<>();
        actualStack.addAll(actualList);
        LinkedList<Integer> actualLinkedList = new LinkedList<>(actualList);

        assertEquals(expectedList , actualList);
        assertEquals(expectedStack , actualStack);
        assertEquals(expectedLinkedList , actualLinkedList);
    }

    @Test
    public void testApplyDiscount(){
        assumeTrue(calculator.divide(hairSalon.getHaircutPrice(), 2) == 15);
        // applyDiscount depends on calculator.divide method so we assume it works fine then below code works

        int expected = 20;
        int actual = hairSalon.applyDiscount();
        assertEquals(expected, actual);
    }

}
