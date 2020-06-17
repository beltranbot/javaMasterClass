package com.beltranbot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    private final static String FILENAME_TXT = "data.txt";
    private final static String FILENAME_DAT = "data.dat";

    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream(FILENAME_DAT)) {
            FileChannel binChannel = binFile.getChannel();
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void readingAndWritingWithJavaNIO() {
        try {
//            FileInputStream file = new FileInputStream(FILENAME);
//            FileChannel channel = file.getChannel();

            Path dataPath = FileSystems.getDefault().getPath(FILENAME_TXT);
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
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
