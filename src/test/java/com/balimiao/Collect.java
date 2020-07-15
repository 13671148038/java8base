package com.balimiao;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhushaopeng
 * @Date 2019/9/30
 **/
public class Collect {

    @Test
    public void a() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(2);
        list.sort((a, b) -> a.compareTo(b));
        list.forEach(c -> System.out.println(c));
    }

    @Test
    public void aa() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("aaaaa", "aaaaaa");
        list.add(map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("bbbbb", "bbbbb");
        list.add(map2);
        Map<String, String> map3 = new HashMap<>();
        map3.put("aaaaa", "aaaaaa");
        list.add(map3);
        Set<Map<String, String>> collect = list.stream().collect(Collectors.toSet());
        System.out.println(collect.size());
    }

    @Test
    public void aaa() {
        final List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        objects.add(3);
        System.out.println(objects);
        List<Object> object4 = Collections.synchronizedList(new ArrayList<>());
        object4.add(5);
        System.out.println(object4);
        System.out.println(objects == object4);
        List<ArrayList<Object>> arrayLists = Collections.singletonList(new ArrayList<>());
        arrayLists = Collections.singletonList(new ArrayList<>());
    }

    @Test
    public void cccc() {

        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }
//        final long l = System.currentTimeMillis();
//        list.parallelStream().forEach(c -> {
//            final String name = Thread.currentThread().getName();
//            System.out.println(name);
//        });
//        final long l1 = System.currentTimeMillis();
//        System.out.println(l1 - l);
//        System.out.println("--------------------------");
//        final long l2 = System.currentTimeMillis();
//        list.stream().forEach(c -> {
//            final String name = Thread.currentThread().getName();
//            System.out.println(name);
//        });
//        final long l3 = System.currentTimeMillis();
//        System.out.println(l3 - l2);

        final List<Integer> collect = list.parallelStream().sorted(Integer::compare).collect(Collectors.toList());
        System.out.println(collect);

    }

}
