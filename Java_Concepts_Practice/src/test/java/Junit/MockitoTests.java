package Junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    Calculator calculatorMethods;

    @BeforeEach
    public void setUp(){
        Mockito.when(calculatorMethods.divide(6,2)).thenReturn(2);
    }

    @Test
    public void testDiv(){
        assertEquals(2, calculatorMethods.divide(6,2));
    }

}
