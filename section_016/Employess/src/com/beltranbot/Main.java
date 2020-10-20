package com.beltranbot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 53);
        Employee charming = new Employee("Prince charming", 31);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(jack);
        employeeList.add(snow);
        employeeList.add(red);
        employeeList.add(charming);

        printEmployeesByAge(
                employeeList,
                "Employees over 30",
                employee -> employee.getAge() > 30
        );
        printEmployeesByAge(
                employeeList,
                "Employees 30 and under",
                employee -> employee.getAge() <= 30
        );

    }

    private static void printEmployeesByAge(
            List<Employee> employeeList,
            String ageText,
            Predicate<Employee> ageCondition
    ) {
        System.out.println(ageText);
        System.out.println("==================");
        for (Employee employee : employeeList) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

    }
}
