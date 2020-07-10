package com.beltranbot;

import static com.beltranbot.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from another thread");
    }
}
