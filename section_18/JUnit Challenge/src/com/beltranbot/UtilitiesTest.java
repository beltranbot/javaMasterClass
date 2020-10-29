package com.beltranbot;

import java.util.Random;

import static org.junit.Assert.*;

public class UtilitiesTest {
    static Utilities utilities;

    @org.junit.BeforeClass
    public static void beforeClass() {
        utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] actual = utilities.everyNthChar(new char[] {'H', 'E', 'L', 'L', 'O'}, 2);
        assertArrayEquals("Wrong Output", new char[] {'E', 'L'}, actual);
    }

    @org.junit.Test
    public void everyNthChar_nGreaterThanLength() {
        char[] source = {'H', 'E', 'L', 'L', 'O'};
        char[] actual = utilities.everyNthChar(source, 6);
        assertArrayEquals("Wrong Output", source, actual);
    }

    @org.junit.Test
    public void removePairs_1() {
        assertEquals("Wrong output", "ABCDEF", utilities.removePairs("ABBCDEEF"));
    }

    @org.junit.Test
    public void removePairs_2() {
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairs("ABCBDEEF"));
    }

    @org.junit.Test
    public void removePairs_length2ReturnsSource() {
        assertEquals("Wrong output", "AB", utilities.removePairs("AB"));
    }

    @org.junit.Test
    public void removePairs_ABC() {
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String source = generateRandomSource();
        assertEquals("Wrong output", expected, utilities.removePairs(source.toString()));
    }

    private static String generateRandomSource() {
        StringBuilder source = new StringBuilder();
        Random random = new Random();
        int j = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            source.append(i);
            j = random.nextInt(100);
            for (int k = 0; k < j; k++) {
                source.append(i);
            }
        }

        return source.toString();
    }

    @org.junit.Test
    public void removePairsRegExp() {
        assertEquals("Wrong output", "ABCDEF", utilities.removePairsRegExp("ABBCDEEF"));
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairsRegExp("ABCBDEEF"));
        assertEquals("Wrong output", "AB", utilities.removePairsRegExp("AB"));
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals("Wrong output", expected, utilities.removePairsRegExp(generateRandomSource()));
    }

    @org.junit.Test
    public void converter() {
        assertEquals("Wrong output", 300, utilities.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_ArithmeticException() throws Exception {
        utilities.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddlength_even() {
        String source = "even";
        assertEquals("Wrong output", source, utilities.nullIfOddlength(source));
    }

    @org.junit.Test
    public void nullIfOddlength_odd() {
        Utilities utilities = new Utilities();
        assertNull("Wrong output", utilities.nullIfOddlength("odd"));
    }
}