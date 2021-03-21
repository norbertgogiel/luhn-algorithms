package com.norbertgogiel;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestLuhnAlgorithms {

    @Test
    public void testLongIsValid() {
        Assertions.assertEquals(true, LuhnAlgorithms.isValid(4444333322221111L));
    }

    @Test
    public void testLongIsNotValid() {
        Assertions.assertEquals(false, LuhnAlgorithms.isValid(4444333322221112L));
    }

    @Test
    public void testStringIsValid() {
        Assertions.assertEquals(true, LuhnAlgorithms.isValid("4444333322221111"));
    }

    @Test
    public void testStringIsNotValid() {
        Assertions.assertEquals(false, LuhnAlgorithms.isValid("4444333322221112"));
    }
}
