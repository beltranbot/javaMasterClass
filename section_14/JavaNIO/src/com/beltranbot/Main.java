package com.beltranbot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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

//            readingBinaryFileUsingJavaIO(outputBytes);
            RandomAccessFile randomAccessFile = new RandomAccessFile(FILENAME_DAT, "rwd");
            FileChannel channel = randomAccessFile.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }
            // Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            // Relative read
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());
            //            intBuffer.flip();
            //            numBytesRead = channel.read(intBuffer);
            //            intBuffer.flip();
            //            System.out.println(intBuffer.getInt());
            //            channel.close();
            //            randomAccessFile.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void readingBinaryFileUsingJavaIO(byte[] outputBytes) throws IOException{
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILENAME_DAT, "rwd");
        byte[] b = new byte[outputBytes.length];
        randomAccessFile.read(b);
        System.out.println(new String(b));

        long int1 = randomAccessFile.readInt();
        long int2 = randomAccessFile.readInt();
        System.out.println(int1);
        System.out.println(int2);
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
