package com.balimiao;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().toString());
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("5");
        List<String> list2 = new ArrayList<>();
        list2.add("567");
        list2.add("5tty");
        List<String> list3 = new ArrayList<>();
        list3.add("fvdsf");
        list3.add("fvdsf");
        list3.add("fvdsf");
        List<String> collect = Stream.of(list1, list2, list3).flatMap(c -> c.stream()).collect(Collectors.toList());
        System.out.println(collect.size());
    }


}
