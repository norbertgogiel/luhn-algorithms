package com.norbertgogiel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class TestLuhnAlgorithms {

    @Test
    public void testLongIsValid() {
        assertTrue(LuhnAlgorithms.isValid(4444333322221111L));
    }

    @Test
    public void testLongIsNotValid() {
        assertFalse(LuhnAlgorithms.isValid(4444333322221112L));
    }

    @Test
    public void testStringIsValid() {
        assertTrue(LuhnAlgorithms.isValid("4444333322221111"));
    }

    @Test
    public void testStringIsNotValid() {
        assertFalse(LuhnAlgorithms.isValid("4444333322221112"));
    }

    @Test
    public void testStringBiggerThanMaxLongAndThrows() {
        assertThrows(NumberFormatException.class, () -> LuhnAlgorithms.isValid("9223372036854775808"));
    }

    @Test
    public void testStringContainsNotNumberASCIIAndThrows() {
        assertThrows(NumberFormatException.class, () -> LuhnAlgorithms.isValid("a/+@!"));
    }

    @Test
    public void testGenerateLuhnNumber() {
        long testNumber = LuhnAlgorithms.generateLuhnFromRange(111,222, 5);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }
}
