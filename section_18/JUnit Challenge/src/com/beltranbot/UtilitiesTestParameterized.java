package com.beltranbot;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {

    private Utilities utilities;
    private String expected;
    private String source;

    public UtilitiesTestParameterized(String source, String expected) {
        this.expected = expected;
        this.source = source;
    }

    @org.junit.Before
    public void setup() {
        utilities = new Utilities();
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }

    @org.junit.Test
    public void removePairRegExp() {
//        assertEquals("wrong answer", expected, utilities.removePairsRegExp(source));
        assertEquals("wrong answer", expected, utilities.removePairs(source));
    }
}
