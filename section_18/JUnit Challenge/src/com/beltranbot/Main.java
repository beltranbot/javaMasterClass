package com.beltranbot;

public class Main {

    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        System.out.println(utilities.removePairs("ABBCDEEF"));
//        String repeated = "aaaabbbbcccddddeeeff";
//        String replaced = repeated.replaceAll("(.)+\1", "$1");
//        System.out.println("Replaced: " + replaced);
        test();

    }

    public static void test() {
//        Pattern p = Pattern.compile("(\\d)(.*)(\\d)");
//        String input = "6 example input 4";
//        Matcher m = p.matcher(input);
//        if (m.find()) {
//            // replace first number with "number" and second number with the first
//            String output = m.replaceFirst("number $3$1");  // number 46
//        }
        System.out.println("----- test -----");
        String input = "aaaabbbbcccddddeeeff";
        String res = input.replaceAll("(.)(\\1+)", "$1");
        System.out.println(res);
    }
}
