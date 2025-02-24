package com.jpdev.junit5.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class EnumSourceTest {

    @ParameterizedTest
    @EnumSource(Day.class)
    void testNoNull(Day day) {
        assertNotNull(day);
    }

    @DisplayName("Return false when day is not weekday")
    @ParameterizedTest
    @EnumSource(value = Day.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"})
    void returnFalseWhenDayIsNotWeekday(Day day) {
        assertTrue(day.isWeekday());
    }

    @DisplayName("Return true when day is weekday")
    @ParameterizedTest
    @EnumSource(value = Day.class, names = {"SATURDAY", "SUNDAY"})
    void returnTrueWhenDayIsWeekday(Day day) {
        assertFalse(day.isWeekday());
    }

}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekday() {
        return this != SATURDAY && this != SUNDAY;
    }
}
