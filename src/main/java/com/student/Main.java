package com.student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Драйвер-класс для работы с Employee.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Введите количество сотрудников: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {

            System.out.println("Сотрудник #" + (i + 1));

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();

            System.out.print("Зарплата: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            Employee employee = new Employee(name, age, salary);
            employees.add(employee);
        }

        System.out.println("\nСписок сотрудников:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        scanner.close();
    }
}