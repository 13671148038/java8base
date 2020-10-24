package com.balimiao.myvolatile;

public class VolatileDemo11 {

    static boolean running = true;
    static Thread t1;

    public static void main(String[] args) throws InterruptedException {
        traditional();
        Thread.sleep(1000);
        running = false;
        System.out.println(running);
    }

    public static void traditional() {
        t1 = new Thread() {
            @Override
            public void run() {
                while (running) {
                    System.out.println(11);
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
