package com.basic.exer3;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNow = scanner.nextInt();
        Employee[] employees = new Employee[2];

        employees[0] = new HourlyEmployee("John", 1001, new MyDate(1999, 10, 1), 500, 10);
        employees[1] = new SalariedEmployee("Bob", 1002, new MyDate(1998, 12, 25), 10000);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            int salary = employees[i].earnings();
            if (monthNow == employees[i].getBirthday().getMonth()) salary += 100;
            System.out.println(salary);
        }
    }



}
