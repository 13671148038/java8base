package com.balimiao.lambdademo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLambda {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("s");
        list.add("d");
        list.add("f");

        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> integers = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> numbers = Arrays.asList(9, 9, 8);
        list2.add(integers);
        list2.add(numbers);
        numbers.stream();
        Integer reduce = Stream.of(integers,numbers).flatMap(d->d.stream()).reduce((integer, integer2) -> integer + integer2).get();
        System.out.println("reduce" + reduce);


//        List<Integer> collect = list2.stream().flatMap(c ->
//                c.stream()
//        ).collect(Collectors.toList());
//        collect.forEach(c ->
//                System.out.println(c)
//        );
//        List<?> collect = Stream.of(list, list2.stream()
//                .flatMap(d -> d.stream())
//                .collect(Collectors.toList()))
//                .flatMap(c -> c.stream())
//                .collect(Collectors.toList());
//        collect.forEach(c ->
//                System.out.println(c));

    }

}
