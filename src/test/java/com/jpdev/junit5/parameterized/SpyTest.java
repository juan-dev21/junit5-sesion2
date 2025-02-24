package com.jpdev.junit5.parameterized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpyTest {

    @Spy
    Calculator calculator;

    @InjectMocks
    MathService mathService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSpy() {
        doReturn(10).when(calculator).add(5, 5);

        int result = mathService.calculateSum(5, 5);

        assertEquals(10, result);

        verify(calculator, times(1)).add(5, 5);
    }



}

class Calculator {
    int add(int a, int b) { return a + b; }
}

class MathService {

    private final Calculator calculator;

    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }

    int calculateSum(int a, int b) {
        return calculator.add(a, b);
    }
}
