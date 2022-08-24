import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /*@Test
    public void greetingTest() {
        System.out.println("First test of method");
        Greeting greeting = new Greeting();
        String actual = greeting.sayHello();
        String expected = "Hello";
        assertEquals(expected, actual);
    }*/

    @Test
    public void greetingTest_givenASingleName() {
        System.out.println("Greeting test given a single name");
        Greeting greeting = new Greeting();

        //greeting with one name
        String actual = greeting.greet("Owais");
        String expected = "Hello, Owais.";
        assertEquals(expected, actual);

        //greeting with array of names
    }

    @Test
    public void greetingTest_givenNull() {
        System.out.println("Greeting test given null value");
        Greeting greeting = new Greeting();

        String actual = greeting.greet(null);
        String expected = "Hello, my friend.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingTest_givenUppercaseName() {
        System.out.println("Greeting test given fully uppercase name");
        Greeting greeting = new Greeting();
        String actual = greeting.greet("OWAIS");
        String expected = "HELLO OWAIS!";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingTest_givenArrayOfNames() {
        System.out.println("Greeting test given an array of names");
        Greeting greeting = new Greeting();
        String[] myNameArray = {"Owais", "Bryan"};
        String actual = greeting.greet(myNameArray);
        String expected = "Hello, Owais and Bryan.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingTest_givenASingleNameInTheNameArray() {
        System.out.println("Greeting test given a single element in the names array");
        Greeting greeting = new Greeting();
        String[] myNameArray = {"Owais"};
        String actual = greeting.greet(myNameArray);
        String expected = "Hello, Owais.";
        assertEquals(expected, actual);
    }

    @Test
    public void greetingTest_givenArbitraryNumberOfNamesInArray() {
        System.out.println("Greeting test given an arbitrary number of names in an array");
        Greeting greeting = new Greeting();

        String[] myNameArray = {"Owais", "Bryan", "Anne", "Carlos", "Junita"};
        String actual = greeting.greet(myNameArray);
        String expected = "Hello, Owais, Bryan, Anne, Carlos, and Junita.";
        assertEquals(actual, expected);

        // testing for 0 elements in the array
        String[] myNameArray2 = {};
        String actual2 = greeting.greet(myNameArray2);
        String expected2 = "Hello, anonymous!";
        assertEquals(expected2, actual2);

        //testing for 1 element in the array
        String[] myNameArray3 = {"Owais"};
        String actual3 = greeting.greet(myNameArray3);
        String expected3 = "Hello, Owais.";
        assertEquals(expected3, actual3);

        //testing for 2 elements in the array
        String[] myNameArray4 = {"Owais", "Bryan"};
        String actual4 = greeting.greet(myNameArray4);
        String expected4 = "Hello, Owais and Bryan.";
        assertEquals(expected4, actual4);
    }

    @Test
    public void greetingTest_givenMixedUppercaseAndLowercaseNamesInNameArray() {
        System.out.println("Greeting test given mixed uppercase and lowercase names in names array");
        Greeting greeting = new Greeting();

        //testing for > 2 amounts of names in the name array MANGLER DEN HER
        String[] myNames = {"Owais", "ANNE", "Bryan", "CARLOS"};
        String actual = greeting.greet(myNames);
        String expected = "Hello, Owais and Bryan. AND HELLO ANNE AND CARLOS.";
        assertEquals(expected, actual);

        //testing for 1 lowercase and 1 shouted name
        String[] myNames2 = {"Owais", "BRYAN"};
        String actual2 = greeting.greet(myNames2);
        String expected2 = "Hello, Owais. AND HELLO BRYAN.";
        assertEquals(expected2, actual2);

        //testing for 2 lowercase and 1 shouted
        String[] myNames3 = {"Owais", "Bryan", "CARLOS"};
        String actual3 = greeting.greet(myNames3);
        String expected3 = "Hello, Owais, and Bryan. AND HELLO CARLOS.";
        assertEquals(expected3, actual3);

        //testing for 1 lowercase and 2 shouted
        String[] myNames4 = {"Owais", "BRYAN", "CARLOS"};
        String actual4 = greeting.greet(myNames4);
        String expected4 = "Hello, Owais. AND HELLO BRYAN AND CARLOS.";
        assertEquals(expected4, actual4);
    }

    @Test
    public void greetingTest_givenMultipleNamesInOneSeperatedByCommas() {
        System.out.println("Greeting test given multiple names in one string seperated by commas");
        Greeting greeting = new Greeting();
        String[] myNames = {"Bob", "Charlie, Dianne"};
        String actual = greeting.greet(myNames);
        String expected = "Hello, Bob, Charlie, and Dianne.";
        assertEquals(expected, actual);

        // TEST A COUPLE EXTRA EDGE CASES
    }

    @Test
    public void greetingTest_allowInputWithIntentionalCommasWithEscapeCharacters() {
        System.out.println("Greeting test testing the allowance of elements having commas in the input with escape characters");
        Greeting greeting = new Greeting();
        String[] myNames = {"Bob", "\"Charlie, Dianne\""};
        String actual = greeting.greet(myNames);
        String expected = "Hello, Bob and Charlie, Dianne";
        assertEquals(expected, actual);
    }


}
