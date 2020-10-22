package com.beltranbot;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        fail("This test has yet to be implemented.");
    }

    @org.junit.Test
    public void removePairs_1() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "ABCDEF", utilities.removePairs("ABBCDEEF"));
    }

    @org.junit.Test
    public void removePairs_2() {
        Utilities utilities = new Utilities();
        System.out.println(utilities.removePairs("ABCBDEEF"));
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairs("ABCBDEEF"));
    }

    @org.junit.Test
    public void removePairsRegExp() {
        Utilities utilities = new Utilities();
        assertEquals("Wrong output", "ABCDEF", utilities.removePairsRegExp("ABBCDEEF"));
        assertEquals("Wrong output", "ABCBDEF", utilities.removePairsRegExp("ABCBDEEF"));
    }

    @org.junit.Test
    public void converter() {
        fail("This test has yet to be implemented.");
    }

    @org.junit.Test
    public void nullIfOddlength() {
        fail("This test has yet to be implemented.");
    }
}