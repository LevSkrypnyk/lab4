package com.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Employee e = new Employee("Лев", 30, 1000, "Дизайн", 5);

        assertThrows(IllegalArgumentException.class, () -> e.setSalary(-1));
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () ->
                new Employee("   ", 25, 1000, "IT", 3)
        );
    }
}