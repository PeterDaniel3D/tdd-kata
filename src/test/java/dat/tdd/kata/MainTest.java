package dat.tdd.kata;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Requirement 1
    @Test
    public void greetTest() {
        String name = "Bob";
        String expected = "Hello, Bob";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 2
    @Test
    public void greetNullTest() {
        String name = null;
        String expected = "Hello, my friend.";
        String actual = Main.greetNull(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 3
    @Test
    public void shoutTest() {
        String name = "JERRY";
        String expected = "HELLO JERRY!";
        String actual = Main.shout(name);
        assertEquals(expected, actual);
    }
    
    // Requirement 4
    @Test
    public void twoNamesTest() {
        String[] names = {"Jill", "Jane"};
        String expected = "Hello, Jill and Jane.";
        String actual = Main.twoNames(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 5
    @Test
    public void arbitraryNumberTest() {
        List<String> names = new ArrayList<>();
        names.add("Amy");
        names.add("Brian");
        names.add("Charlotte");
        String expected = "Hello, Amy, Brian, and Charlotte.";
        String actual = Main.arbitraryNumber(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 6
    @Test
    public void mixNormalAndShoutTest() {
        String[] names = {"Amy", "BRIAN", "Charlotte"};
        String expected = "Hello, Amy, and Charlotte. AND HELLO BRIAN!";
        String actual = Main.mixNormalAndShout(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 7
    @Test
    public void splitCommaTest() {
        String[] names = {"Bob", "Charlie, Dianne"};
        String expected = "Hello, Bob, Charlie, and Dianne.";
        String actual = Main.splitComma(names);
        assertEquals(expected, actual);
    }
    
    // Requirement 8
    @Test
    public void escapeCommasTest() {
        String[] names = {"Bob", "\"Charlie, Dianne\""};
        String expected = "Hello, Bob and Charlie, Dianne.";
        String actual = Main.escapeCommas(names);
        assertEquals(expected, actual);
    }
}
