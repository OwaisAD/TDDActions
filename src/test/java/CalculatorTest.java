import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNumbers() {
        System.out.println("Testing adding 2 numbers");
        int actual = new Calculator().addNumbers(10, 5);
        int expected = 15;
        assertEquals(expected, actual);
    }
}