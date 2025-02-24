package com.jpdev.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 15})
    void testIsPositive(int number) {
        assertTrue(number > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "hector", "hidalgo"})
    void testIsPositive(String text) {
        assertFalse(text.isEmpty());
    }
}
