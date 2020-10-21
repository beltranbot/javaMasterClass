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
}
