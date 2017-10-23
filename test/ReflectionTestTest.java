import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReflectionTestTest {

    ClassA object;

    @Before
    public void init() {
        object = new ClassA();
    }


    @Test
    public void shouldInitializeFieldsWithDefaultValues() {
        //given
        int expectedInt = 10;
        String expectedLine = "Default";
        //when
        ReflectionTest.initializeFields(object);
        int resultInt = object.getNumber();
        String resultLine = object.getText();
        //
        assertEquals("test failed", expectedLine + " " + expectedInt,
                resultLine + " " + resultInt);
    }

    @Test
    public void shouldInvokeMethodClassA() {
        //given
        int number = 100;
        String line = "This is a line";
        String expected = line + " " + number;
        //when
        String actual = ReflectionTest.invokeMethod(object, line, number);
        //
        assertEquals("test failed", actual, expected);
    }
}