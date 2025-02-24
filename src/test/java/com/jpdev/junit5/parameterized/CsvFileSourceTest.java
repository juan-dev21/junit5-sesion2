package com.jpdev.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvFileSourceTest {

    // numLinesToSkip usando para excluir si tienes una cabecera en el archivo csv
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testDivision(int dividendo, int divisor, int cociente) {
        assertEquals(cociente, MathDuvUtil.divide(dividendo, divisor));
    }

}

class MathDuvUtil {

    static int divide(int a, int b) {
        return a / b;
    }
}