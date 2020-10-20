package com.beltranbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
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

        Function<Employee, String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(' ') + 1);
        Function<Employee, String> getFirstName = employee -> employee.getName().substring(0, employee.getName().indexOf(' '));

        Random random1 = new Random();
        for (Employee employee : employeeList) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
