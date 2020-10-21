package com.beltranbot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        challenge1();
        challenge2();
        challenge3();
        challenge4();
        challenge5();
        challenge6();
        challenge7();
        challenge8();
        challenge9();
        challenge10();
        challenge11();
        challenge12();
        challenge13();
        challenge14();
    }

    public static void challenge1() {
        System.out.println("--- challenge 1 ---");
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("^I want a bike.$"));
    }

    public static void challenge2() {
        System.out.println("--- challenge 2 ---");
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regex = "^I want a (bike|ball).$";
        System.out.println(challenge1.matches(regex));
        System.out.println(challenge2.matches(regex));
    }

    public static void challenge3() {
        System.out.println("--- challenge 3 ---");
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        Pattern pattern = Pattern.compile("^I want a (bike|ball).$");
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());
    }

    public static void challenge4() {
        System.out.println("--- challenge 4 ---");
        String challenge4 = "Replace all blanks with underscore.";
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }

    public static void challenge5() {
        System.out.println("--- challenge 5 ---");
        String challenge5 = "aaabccccccccdddefffg";
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher(challenge5);
        System.out.println(matcher.matches());
    }

    public static void challenge6() {
        System.out.println("--- challenge 6 ---");
        String challenge5 = "aaabccccccccdddefffg";
        Pattern pattern = Pattern.compile("a{3}bc{8}d{3}ef{3}g$");
        Matcher matcher = pattern.matcher(challenge5);
        System.out.println(matcher.matches());
    }

    public static void challenge7() {
        System.out.println("--- challenge 7 ---");
        String challenge7 = "abcd.135";
        String regEx = "^[a-zA-Z]+\\.[0-9]+$";
        System.out.println(challenge7.matches(regEx));
    }

    public static void challenge8() {
        System.out.println("--- challenge 8 ---");
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String regEx = "[a-zA-Z]+\\.([0-9]+)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge8);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

    public static void challenge9() {
        System.out.println("--- challenge 9 ---");
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        String regEx = "[a-zA-Z]+\\.([0-9]+)\\s";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge9);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

    public static void challenge10() {
        System.out.println("--- challenge 10 ---");
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        String regEx = "[a-zA-Z]+\\.([0-9]+)\\s";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge9);

        while (matcher.find()) {
            System.out.println(
                    "Occurrence: " +
                            matcher.group(1) +
                            " : " +
                            matcher.start(1) +
                            " to " +
                            (matcher.end(1) - 1)
            );
        }
    }

    public static void challenge11() {
        System.out.println("--- challenge 11 ---");
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";

        String regEx = "\\{(\\d+, \\d+)\\}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge11);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

    public static void challenge12() {
        System.out.println("--- challenge 12 ---");
        String challenge12 = "11111";

        String regEx = "^(\\d{5})$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge12);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

    public static void challenge13() {
        System.out.println("--- challenge 13 ---");
        String challenge13 = "11111-1111";

        String regEx = "^(\\d{5}-\\d{4})$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge13);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

    public static void challenge14() {
        System.out.println("--- challenge 14 ---");
        String challenge12 = "11111-1111";

        String regEx = "^(\\d{5}(-\\d{4})?)$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(challenge12);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }
}
