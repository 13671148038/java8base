package com.balimiao;

import com.balimiao.pojo.YkqUserSearchMedicinesVo;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        List<YkqUserSearchMedicinesVo> list = Arrays.asList(new YkqUserSearchMedicinesVo());
        Map<Integer, YkqUserSearchMedicinesVo> collect = list.stream().collect(Collectors.toMap(a -> a.getDrugstoreId(), b -> b));
        Map<Integer, List<YkqUserSearchMedicinesVo>> collect1 = list.stream().collect(Collectors.groupingBy(YkqUserSearchMedicinesVo::getDrugstoreId));
        Stream<YkqUserSearchMedicinesVo> sorted = list.stream().sorted((a, b) -> a.getDrugstoreId().compareTo(b.getDrugstoreId()));
    }

    @Test
    public void cccc() {

        Map map = new HashMap();
        map.put("sdc", 333);
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }
        list.parallelStream().
                map(c -> Thread.currentThread().getName()).
                forEach(c -> System.out.println(c));

    }

    @Test
    public void ccccc() {
        List<String> integers = Arrays.asList("221", "32", "98987", "32", "54", "879");
        integers.sort((a, b) -> b.compareTo(a));
        System.out.println(integers);
    }

    @Test
    public void ccccddc() {
        List<Integer> list = Arrays.asList(4, 6, 34, 6, 8, 6, 45, 5, 64, 4, 4, 6, 3, 2, 6, 8, 43, 9);
        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);
        List<Integer> collect = list.parallelStream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void urnno() {
        List<Long> list = Arrays.asList(4L, 6L);
        System.out.println(list.stream().map(c->c.toString()).collect(Collectors.joining(",")));
    }

}
