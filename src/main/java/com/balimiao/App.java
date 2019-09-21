package com.balimiao;

import com.balimiao.enumdemo.MyEnum;

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
        MyEnum currency = MyEnum.CURRENCY;
        System.out.println(currency.getDesc());

    }


}
