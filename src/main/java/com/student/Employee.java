package com.student;

import java.util.Objects;

/**
 * Класс Employee представляет сотрудника.
 * Содержит валидацию данных в конструкторе и сеттерах.
 */
public class Employee {

    private String name;           // не пустое
    private int age;               // 18..70
    private double salary;         // >= 0
    private String department;     // не пустое
    private int experienceYears;   // >= 0

    /**
     * Конструктор с параметрами и валидацией.
     *
     * @param name имя сотрудника (не пустое)
     * @param age возраст (18..70)
     * @param salary зарплата (>=0)
     * @param department отдел (не пустой)
     * @param experienceYears стаж в годах (>=0)
     * @throws IllegalArgumentException если данные некорректны
     */
    public Employee(String name, int age, double salary, String department, int experienceYears) {
        setName(name);
        setAge(age);
        setSalary(salary);
        setDepartment(department);
        setExperienceYears(experienceYears);
    }

    public String getName() {
        return name;
    }

    /**
     * @param name не пустое
     */
    public void setName(String name) {
        if (name == null || name.strip().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name.strip();
    }

    public int getAge() {
        return age;
    }

    /**
     * @param age 18..70
     */
    public void setAge(int age) {
        if (age < 18 || age > 70) {
            throw new IllegalArgumentException("Возраст должен быть от 18 до 70");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * @param salary >= 0
     */
    public void setSalary(double salary) {
        if (Double.isNaN(salary) || Double.isInfinite(salary) || salary < 0) {
            throw new IllegalArgumentException("Зарплата должна быть числом и не может быть отрицательной");
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    /**
     * @param department не пустой
     */
    public void setDepartment(String department) {
        if (department == null || department.strip().isEmpty()) {
            throw new IllegalArgumentException("Отдел не может быть пустым");
        }
        this.department = department.strip();
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    /**
     * @param experienceYears >= 0
     */
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Стаж не может быть отрицательным");
        }
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age
                && Double.compare(employee.salary, salary) == 0
                && experienceYears == employee.experienceYears
                && Objects.equals(name, employee.name)
                && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, department, experienceYears);
    }
}