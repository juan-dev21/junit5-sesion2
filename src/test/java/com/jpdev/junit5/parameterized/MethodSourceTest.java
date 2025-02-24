package com.jpdev.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MethodSourceTest {

   static Stream<String> stringProvider() {
       return Stream.of("hello", "world", "junit", " ");
   }

   @ParameterizedTest
   @MethodSource("stringProvider")
   void testStringLength(String input) {
       assertFalse(input.isEmpty());
   }

   //********************************************


   static Stream<Arguments> sumProvider() {
       return Stream.of(
               Arguments.of(2, 3, 5),
               Arguments.of(5, 5, 10),
               Arguments.of(10, -2, 8)
       );
   }

    @ParameterizedTest
    @MethodSource({"sumProvider"})
    void testSum(int a, int b, int expected) {
        assertEquals(expected, MathUtil.sum(a, b));
    }

}
