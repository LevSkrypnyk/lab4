package com.student;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Драйвер-класс с консольным меню и устойчивой обработкой ошибок ввода.
 */
public class Main {

    public static void main(String[] args) {
        // UTF-8 для корректного ввода/вывода (особенно если консоль настроена на UTF-8)
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        List<Employee> employees = new ArrayList<>();

        while (true) {
            printMenu();
            int choice = readInt(scanner, "Выберите пункт: ");

            switch (choice) {
                case 1 -> createEmployeeFlow(scanner, employees);
                case 2 -> printEmployees(employees);
                case 3 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный пункт меню. Попробуйте ещё раз.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Создать сотрудника");
        System.out.println("2. Показать всех сотрудников");
        System.out.println("3. Выход");
    }

    private static void createEmployeeFlow(Scanner scanner, List<Employee> employees) {
        try {
            String name = readNonBlank(scanner, "Имя: ");
            int age = readInt(scanner, "Возраст: ");
            double salary = readDouble(scanner, "Зарплата: ");
            String department = readNonBlank(scanner, "Отдел: ");
            int exp = readInt(scanner, "Стаж (лет): ");

            Employee emp = new Employee(name, age, salary, department, exp);
            employees.add(emp);

            System.out.println("✅ Сотрудник добавлен.");
        } catch (IllegalArgumentException e) {
            // сюда попадёт валидация из Employee (конструктор/сеттеры)
            System.out.println("❌ Ошибка данных: " + e.getMessage());
        }
    }

    private static void printEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.println("\nСписок сотрудников:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ") " + employees.get(i));
        }
    }

    /**
     * Читает непустую строку. Повторяет запрос, пока строка пустая.
     */
    private static String readNonBlank(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line != null && !line.strip().isEmpty()) {
                return line.strip();
            }
            System.out.println("❌ Пустая строка. Введите значение ещё раз.");
        }
    }

    /**
     * Читает int через nextLine() и парсинг. Ловит пустые строки и нечисловой ввод.
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.strip().isEmpty()) {
                System.out.println("❌ Пустая строка. Введите число ещё раз.");
                continue;
            }
            try {
                return Integer.parseInt(line.strip());
            } catch (NumberFormatException e) {
                System.out.println("❌ Это не целое число. Попробуйте ещё раз.");
            }
        }
    }

    /**
     * Читает double через nextLine() и парсинг. Поддерживает запятую.
     */
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.strip().isEmpty()) {
                System.out.println("❌ Пустая строка. Введите число ещё раз.");
                continue;
            }
            line = line.strip().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("❌ Это не число (double). Попробуйте ещё раз.");
            }
        }
    }
}