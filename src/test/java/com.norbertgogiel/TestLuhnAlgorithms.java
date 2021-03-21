package com.norbertgogiel;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestLuhnAlgorithms {

    @Test
    public void testIsValid() {
        Assertions.assertEquals(true, LuhnAlgorithms.isValid(4444333322221111L));
    }
}
