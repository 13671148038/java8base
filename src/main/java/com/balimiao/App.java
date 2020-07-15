package com.balimiao;

import com.balimiao.genericity.MyGenericity;
import com.balimiao.pojo.YkqUserSearchMedicinesVo;
import com.balimiao.scheduler.MyJob;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Integer i = 128;
//        Integer j = 128;
//        System.out.println(i == j);
//        int a = 444;
//        int b = 444;
//        System.out.println(a == b);
        System.out.println("111".hashCode());
        MyJob myJob = new MyJob();
        System.out.println(myJob.hashCode());
        MyGenericity myGenericity = new MyGenericity();
        System.out.println(myGenericity.hashCode());

        Map<String,String> map = new HashMap<>();
        final Collection<String> values = map.values();
        System.out.println(values);

        YkqUserSearchMedicinesVo p = new YkqUserSearchMedicinesVo();
        final boolean ddd = p.isDdd();
        System.out.println(ddd);


    }

}
