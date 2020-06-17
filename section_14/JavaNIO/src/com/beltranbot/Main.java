package com.beltranbot;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    private final static String FILENAME = "data.txt";

    public static void main(String[] args) {
        try {
//            FileInputStream file = new FileInputStream(FILENAME);
//            FileChannel channel = file.getChannel();

            Path dataPath = FileSystems.getDefault().getPath(FILENAME);
            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
