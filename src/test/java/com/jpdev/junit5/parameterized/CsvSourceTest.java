package com.jpdev.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "7, -2, 5",
            "-1, -1, -2"
    })
    void testSum(int a, int b, int expected) {
        assertEquals(expected, MathUtil.sum(a, b));
    }

}

class MathUtil {

    static int sum(int a, int b) {
        return a + b;
    }
}