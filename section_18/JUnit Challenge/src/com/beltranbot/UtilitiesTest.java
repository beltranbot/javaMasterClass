package com.beltranbot;

import java.util.Random;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        Utilities utilities = new Utilities();
        char[] actual = utilities.everyNthChar(new char[] {'H', 'E', 'L', 'L', 'O'}, 2);
        assertArrayEquals("Wrong Output", new char[] {'E', 'L'}, actual);
    }

    @org.junit.Test
    public void everyNthChar_nGreaterThanLength() {
        Utilities utilities = new Utilities();
        char[] source = {'H', 'E', 'L', 'L', 'O'};
        char[] actual = utilities.everyNthChar(source, 6);
        assertArrayEquals("Wrong Output", source, actual);
    }

    @org.junit.Test
    public void removePairs_1() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "ABCDEF", utilities.removePairs("ABBCDEEF"));
    }

    @org.junit.Test
    public void removePairs_2() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairs("ABCBDEEF"));
    }

    @org.junit.Test
    public void removePairs_length2ReturnsSource() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "AB", utilities.removePairs("AB"));
    }

    @org.junit.Test
    public void removePairs_ABC() {
        Utilities utilities = new Utilities();
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
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "ABCDEF", utilities.removePairsRegExp("ABBCDEEF"));
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairsRegExp("ABCBDEEF"));
        assertEquals("Wrong output", "AB", utilities.removePairsRegExp("AB"));
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals("Wrong output", expected, utilities.removePairsRegExp(generateRandomSource()));
    }

    @org.junit.Test
    public void converter() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", 300, utilities.converter(10, 5));
    }

    @org.junit.Test
    public void nullIfOddlength_even() {
        Utilities utilities = new Utilities();
        String source = "even";
        assertEquals("Wrong output", source, utilities.nullIfOddlength(source));
    }

    @org.junit.Test
    public void nullIfOddlength_odd() {
        Utilities utilities = new Utilities();
        assertNull("Wrong output", utilities.nullIfOddlength("odd"));

    }
}