package com.balimiao;

import com.balimiao.enumdemo.WeekEnum;
import com.balimiao.lambdademo.mm.Adc;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        List list = new ArrayList<>();
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        List list2 = new ArrayList<>();
//        list2.add("5656");
//        list.add(list2);
////        Stream.of(list).flatMapToDouble(a->a.stream().flatMapToDouble(c-> DoubleStream.of(Double.valueOf(c+"")))).forEach(c-> System.out.println(c));
//        Stream.of(list).flatMap(c -> c.stream()).forEach(c -> System.out.println(c));
        WeekEnum monday = WeekEnum.MONDAY;
//        System.out.println(monday);
//        System.out.println(monday.name());
//        System.out.println(monday.ordinal());
//        System.out.println(monday.getValue());

        Adc adc = new Adc();
        int aaa = adc.sdc(c -> c + 1, 222);
        System.out.println(aaa);
    }


}
