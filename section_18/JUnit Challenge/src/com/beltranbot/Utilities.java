package com.beltranbot;

public class Utilities {

    // returns a char array containing every nth char..
    // When sourceArray.length < n returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / 2;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            if ((i + 1) == returnedLength) {
                result[index++] = sourceArray[i];
                returnedLength *= 2;
            }
        }

        return result;
    }

    // Removes pairs of the same character that are next
    // to each other, by removing on an occurrence of the character
    // "ABBCDEEF" => "ABCDEF"
    // "ABCBDEEF" => "ABCBDEF" (the two B's aren't next to each other)
    public String removePairs(String source) {
        // If length is less than 2, there won't be any pairs
        if (source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }

        sb.append(string[string.length - 1]);

        return sb.toString();
    }

    public String removePairsRegExp(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }

        return string.replaceAll("(.)(\\1+)", "$1");
    }

    // perform a conversion based on some internal
    // business rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddlength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
