package com.balimiao.threadp;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThread {

    @Test
    public void test1() {
        //创建一个单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
                    int a = 7;
                }
        );
    }
    @Test
    public void test2() throws Exception {
        //创建一个执行制定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            System.out.println(22772);
        });
        executorService.execute(() -> {
                System.out.println(55589577);
                System.out.println(555895);
        });
        //等待所有线程全部执行完成以后再执行
        boolean b = executorService.awaitTermination(1, TimeUnit.SECONDS);
        boolean terminated = executorService.isTerminated();
        System.out.println("terminated:"+terminated);
        System.out.println("execute over");
    }

}
