package com.jpdev.junit5.parameterized.complex;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexTest {

    // Esta parte la he comentado para ejecutar la prueba con una clase externa CustomArgumentProvider2
    // (aquí el ejemplo usa una clase interna CustomArgumentProvider)

    /*static class CustomArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

            String methodName = context.getTestMethod().map(Method::getName).orElse("Unknown");

            if ("testIsAgeGreatThan".equals(methodName)) {
                return Stream.of(
                        Arguments.of(new People("Juan", 30), true),
                        Arguments.of(new People("Hector", 17), false),
                        Arguments.of(new People("Maria", 25), true)
                );
            } else {
                return Stream.of(
                        Arguments.of(new People("Juan", 10), false),
                        Arguments.of(new People("Hector", 18), true)
                );
            }

        }
    }

    static class People {
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        boolean isAgeGreatThan() {
            return age >= 18;
        }
    }*/

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentProvider2.class)
    void testIsAgeGreatThan(People people, boolean expected) {
        assertEquals(expected, people.isAgeGreatThan());
    }


    @ParameterizedTest
    @ArgumentsSource(CustomArgumentProvider2.class)
    void anotherLogic(People people, boolean expected) {
        assertEquals(expected, people.isAgeGreatThan());
    }

}
