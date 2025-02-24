package com.jpdev.junit5.parameterized.complex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @ParameterizedTest
    @CsvSource({
            "2025.01.01, 2025",
            "2023.01.01, 2023",
            "2024.01.01, 2024",
    })
    void testYearExtract(@ConvertWith(DateConverter.class) LocalDate date, int expectedYear) {
        assertEquals(expectedYear, date.getYear());
    }

}

class DateConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String &&  targetType == LocalDate.class) {
            String[] dataSource =  ((String) source).split("\\.");
            return LocalDate.of(Integer.parseInt(dataSource[0]), Integer.parseInt(dataSource[1]), Integer.parseInt(dataSource[2]));
        }
        throw new IllegalArgumentException("Fecha no soportada");
    }
}
