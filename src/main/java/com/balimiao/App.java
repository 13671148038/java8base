package com.balimiao;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.balimiao.pojo.YkqUserSearchMedicinesVo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
//        final Apple apple = aaa("苹果", c -> new Apple(c));
//        System.out.println(apple.getName());
//        final Number sum = sum((a, b) -> a + b, 32, 90);
//        System.out.println(sum);

//        Function<Integer, Integer> t = a -> a * (a + 1);
//        System.out.println(t.apply(4));
//        final Integer apply = t.compose(t).apply(4);
//        System.out.println(apply); //420
//        final Integer apply1 = t.andThen(t).apply(4);
//        System.out.println(apply1); //

        YkqUserSearchMedicinesVo userSearchMedicinesVo = new YkqUserSearchMedicinesVo();
        userSearchMedicinesVo.setDrugstoreName("所产生的(上档次)");
        String value = JSON.toJSONString(userSearchMedicinesVo);
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("%28", "&#40;").replaceAll("%29", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("<script", "＜script");
        userSearchMedicinesVo = JSONObject.parseObject(value, YkqUserSearchMedicinesVo.class);
        System.out.println(JSON.toJSONString(userSearchMedicinesVo));

    }

    public static Number sum(BiFunction<? super Integer, ? super Integer, ? extends Integer> biFunction, Integer a, Integer b) {
        Integer apply = biFunction.apply(a, b);
        return apply;
    }


    public static Apple aaa(String name, Function<String, ? extends Apple> function) {
        Apple apply = function.apply(name);
        return apply;
    }

    public static class Apple {
        private String name;

        public Apple(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
