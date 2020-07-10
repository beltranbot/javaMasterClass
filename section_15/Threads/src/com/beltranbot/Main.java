package com.beltranbot;

import static com.beltranbot.ThreadColor.ANSI_GREEN;
import static com.beltranbot.ThreadColor.ANSI_PURPLE;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "hello from the anonymous class thrad");
            }
        }.start();

        System.out.println(ANSI_PURPLE + "hello again from the main thread.");


    }
}
