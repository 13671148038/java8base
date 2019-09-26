package com.balimiao;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyTime {

    //时钟类Clock
    @Test
    public void test1() {
        Clock clock = Clock.systemUTC();
        //返回当前毫秒值
        long l = clock.instant().toEpochMilli();
        //返回当前毫秒值
        long millis = clock.millis();
        System.out.println(millis);
        System.out.println(l);
    }

    //java8新的时间格式化
    @Test
    public void test2() {
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = isoLocalDateTime.format(LocalDateTime.now());
        System.out.println(format);
    }


    //java8的时间片段
    @Test
    public void test3() {
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
        Duration duration = Duration.between(from, to);
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

    //API的核心time包:它包括日期，时间，组合的日期和时间，时区，瞬间，持续时间和时钟的类

    /**
     * Prefix	 Method Type	                                                       Use
     * of	    static factory	Creates an instance where the factory is primarily validating the input parameters, not converting them.
     * from	static factory	Converts the input parameters to an instance of the target class, which may involve losing information from the input.
     * parse	static factory	Parses the input string to produce an instance of the target class.
     * format	instance	    Uses the specified formatter to format the values in the temporal object to produce a string.
     * get	instance	    Returns a part of the state of the target object.
     * is	    instance	    Queries the state of the target object.
     * with	instance	    Returns a copy of the target object with one element changed; this is the immutable equivalent to a set method on a JavaBean.
     * plus	instance	    Returns a copy of the target object with an amount of time added.
     * minus	instance	    Returns a copy of the target object with an amount of time subtracted.
     * to	    instance	    Converts this object to another type.
     * at	    instance	    Combines this object with another.
     */
    @Test
    public void localDateTime() {
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //时间格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(dateTimeFormatter));
        //获取当前毫秒值
        System.out.println(now.toInstant(ZoneOffset.UTC).toEpochMilli());
        //将毫秒值转为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1569514403534L), ZoneOffset.UTC);
        System.out.println(localDateTime.format(dateTimeFormatter));
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek.getValue());
    }

    @Test
    public void dayOfWeekTest() {
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek of = DayOfWeek.of(4);
        Locale locale = Locale.getDefault();
        System.out.println(monday.getDisplayName(TextStyle.FULL, locale));
        System.out.println(monday.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(monday.getDisplayName(TextStyle.SHORT, locale));
    }

    @Test
    public void MonthTest() {
        Month month = Month.JANUARY;
        Locale locale = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
    }
}
