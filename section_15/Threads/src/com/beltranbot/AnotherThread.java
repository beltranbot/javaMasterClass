package com.beltranbot;

import static com.beltranbot.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from " + currentThread().getName());

        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds hava passed and I'm awake");
    }
}
