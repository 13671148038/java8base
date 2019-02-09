package com.balimiao;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

public class MyTime {

    //时钟类Clock
    @Test
    public void test1()  {
        Clock clock = Clock.systemUTC();
        //返回当前毫秒值
        long millis = clock.millis();
        System.out.println(millis);
    }

    //java8新的时间格式化
    @Test
    public void test2(){
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = isoLocalDateTime.format(LocalDateTime.now());
        System.out.println(format);
    }


    //java8的时间片段
    @Test
    public void test3(){
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
        Duration duration = Duration.between(from,to);
        long l = duration.toDays();
        System.out.println(l);

        Duration duration1 = Duration.ofDays(1);
        long l1 = duration1.toMinutes();
        long seconds = duration1.getSeconds();
        long l2 = duration1.toMillis();
        System.out.println(l1);
        System.out.println(seconds);
        System.out.println(l2);
    }
}
