package com.balimiao;

import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
//        final Apple apple = aaa("苹果", c -> new Apple(c));
//        System.out.println(apple.getName());
//        final Number sum = sum((a, b) -> a + b, 32, 90);
//        System.out.println(sum);

        String a = "a";
        String b = new String("a");
        b = a;
        System.out.println(a==b);

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
