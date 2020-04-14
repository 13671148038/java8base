package com.balimiao;

import com.balimiao.staticclass.Adddd;
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
    public  void aaa(){
//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        list.add(2);
//        list = list.stream().filter(c->c.equals(3)).collect(Collectors.toList());
////        System.out.println(list);
//        String customPriceStr = "50.056";
//        final double v = Double.parseDouble(customPriceStr);
//        System.out.println(v);
//        int cd = customPriceStr.length() - customPriceStr.indexOf(".") - 1;
//        System.out.println(cd);

        Integer a = -5;
        System.out.println(a.compareTo(0));
    }

}
