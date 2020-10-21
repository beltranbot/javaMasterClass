package com.beltranbot;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        challenge1();
//      challenge2
        Function<String, String> lambdaFunction = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }

            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar(lambdaFunction, "1234567890"));
        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        long number = topNames2015
                .stream()
                .filter(s -> s.toUpperCase().startsWith("A"))
                .count();
        System.out.println("Number of names that start with A: " + number);
    }

    private static void challenge1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);

            }
        };

        new Thread(runnableLambda).start();
    }

    private static String everySecondChar(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
