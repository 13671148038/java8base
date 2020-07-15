package com.balimiao.myvolatile;

public class VolatileDemo {

    static boolean running = true;
    static Integer i = 1;
    static int j = 1;
    static Thread t1;

    public static void main(String[] args) throws InterruptedException {
        traditional();
        Thread.sleep(10);
        running = false;
    }

    public static void traditional() {
        t1 = new Thread() {
            @Override
            public void run() {
                while (running) {
                    j++;
                }
            }
        };
        t1.start();
    }

    private static void aa() {
        try {
            Thread.sleep(1000);
            System.out.println("t1-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
