package com.balimiao.myvolatile;

import java.util.concurrent.TimeUnit;

public class VolatileDemo2 {

    volatile static boolean running = true;
    static Thread t1 ;
    public static void main(String[] args) throws InterruptedException {
        traditional();
        Thread.sleep(1000);
        running =false;
        System.out.println(running);
    }

    public static void traditional(){
        t1= new Thread(){
            @Override
            public void run(){
                while (running){
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
