package com.beltranbot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    private final static String FILENAME_TXT = "data.txt";
    private final static String FILENAME_DAT = "data.dat";

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();
            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader thread: "  + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private static void helperFunction1() {
        try (
                FileOutputStream binFile = new FileOutputStream(FILENAME_DAT);
                FileChannel binChannel = binFile.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputByte2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes)
//                    .putInt(245)
//                    .putInt(-98765)
//                    .put(outputByte2)
//                    .putInt(1000);
//            buffer.flip(); // flip between writing to the buffer to reading to the buffer

            /*
             * read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
             * update teh position accordingly.
             * Note that now we¡re talking about the channel's position, not the byte buffer¡s position.
             * Of course, the bytes will be placed into the buffer starting  at its current position.
             *
             * write(ByteBuffer) - the same as read, except it writes. There's one exception.
             * If a datasource is opened in APPEND mode, then the first write will take place starting
             * at the end of the datasource, rather than at position 0. After the write, the position
             * will be updated accordingly.
             *
             * position() - returns the channel's position.
             * position(long) - sets the channel's position to the passed value.
             * truncate(long) - truncates the size of the attached datasource to the passed value.
             * size() - returns the size of the attached datasource
             *
             * */

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputByte2 = "Nice to meet you".getBytes();
            buffer.put(outputByte2);
            long int3Pos = int2Pos + Integer.BYTES + outputByte2.length;
            buffer.putInt(1000);
            buffer.flip(); // flip between writing to the buffer to reading to the buffer

            binChannel.write(buffer);

            RandomAccessFile randomAccessFile = new RandomAccessFile(FILENAME_DAT, "rwd");
            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());

            channel.position(int1Pos);
            readBuffer.flip();
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            randomAccessFile.close();
            copyChannel.close();

//            byte[] outputString = "Hello, World!".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);gnel.
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 =  " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputByte2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

        } catch (IOException exception) {

        }
    }

    private static void writingOneVariableAtTheTimeNIO() {
        try (FileOutputStream binFile = new FileOutputStream(FILENAME_DAT)) {
            FileChannel binChannel = binFile.getChannel();
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();
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
//                System.out.println("byte buffer = " + new String(outputBytes));
            }
            // Absolute read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println(intBuffer.getInt());

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

    private static void readingBinaryFileUsingJavaIO(byte[] outputBytes) throws IOException {
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
