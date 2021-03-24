package com.norbertgogiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class TestLuhnAlgorithms {

    @Test
    public void testEvenLengthLongIsValid() {
        assertTrue(LuhnAlgorithms.isValid(4716881992809921L));
    }

    @Test
    public void testOddLengthLongIsValid() {
        assertTrue(LuhnAlgorithms.isValid(372095199917337L));
    }

    @Test
    public void testLongIsNotValid() {
        assertFalse(LuhnAlgorithms.isValid(4444333322221112L));
    }

    @Test
    public void testStringIsValid() {
        assertTrue(LuhnAlgorithms.isValid("4716881992809921"));
    }

    @Test
    public void testStringIsNotValid() {
        assertFalse(LuhnAlgorithms.isValid("4444333322221112"));
    }

    @Test
    public void testStringIsEmptyAndThrows() {
        assertThrows(NumberFormatException.class, () -> LuhnAlgorithms.isValid(""));
    }

    @Test
    public void testNullAndThrows() {
        assertThrows(NumberFormatException.class, () -> LuhnAlgorithms.isValid(null));
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
    public void testGenerateOddLengthLuhnNumber() {
        long testNumber = LuhnAlgorithms.generateLuhnFromRange(111,222, 5);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }

    @Test
    public void testGenerateEvenLengthLuhnNumber() {
        long testNumber = LuhnAlgorithms.generateLuhnFromRange(111,222, 6);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }

    @Test
    public void testGenerateEvenRandomLuhn() {
        long testNumber = LuhnAlgorithms.generateRandomLuhn(10);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }

    @Test
    public void testGenerateOddRandomLuhn() {
        long testNumber = LuhnAlgorithms.generateRandomLuhn(11);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }

    @Test
    public void testGenerateRandomLuhnOfLengthOne() {
        long testNumber = LuhnAlgorithms.generateRandomLuhn(1);
        assertEquals(0, testNumber);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }

    @Test
    public void testGenerateRandomLuhnOfLengthTwo() {
        long testNumber = LuhnAlgorithms.generateRandomLuhn(2);
        assertTrue(testNumber < 100);
        assertTrue(LuhnAlgorithms.isValid(testNumber));
    }
}
