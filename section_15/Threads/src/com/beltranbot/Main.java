package com.beltranbot;

import static com.beltranbot.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "hello from the anonymous class thread");
            }
        }.start();

        Thread ogRunnableThread = new Thread(new MyRunnable());
        ogRunnableThread.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "hello from the anonymous class's run()");
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "hello again from the main thread.");

    }
}
