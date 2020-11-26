package com.balimiao;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {

        System.out.println(String.class.getClassLoader());

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(9);

        StringBuilder stringBuilder = new StringBuilder();
        while (l1 != null) {
            stringBuilder.append(String.valueOf(l1.val), 0, 1);
            l1 = l1.next;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (l2 != null) {
            stringBuilder2.append(String.valueOf(l2.val), 0, 1);
            l2 = l2.next;
        }
        String s = new BigInteger(stringBuilder.toString()).add(new BigInteger(stringBuilder2.toString())).toString();
        String[] split = s.split("");
        List<String> list = Arrays.asList(split);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
