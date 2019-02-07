package com.balimiao;

import org.junit.Test;

import java.util.Optional;

public class MyOptional {

    @Test
    public void test1(){
        String a = "sdcsd";
        //orElse 的方法不管Optional是不是null都会执行.
        String s = Optional.ofNullable(a).orElse(b());
        System.out.println(s);
        //orElseGet 的方法只有当Optional是null的时候才会执行.
        String s1 = Optional.ofNullable(a).orElseGet(new MyOptional()::b);
        System.out.println(s1);

        String b = null;
        //orElse 的方法不管Optional是不是null都会执行.
        String s3 = Optional.ofNullable(b).orElse(b());
        System.out.println(s3);
        //orElseGet 的方法只有当Optional是null的时候才会执行.
        String s4 = Optional.ofNullable(b).orElseGet(new MyOptional()::b);
        System.out.println(s4);

        Optional.ofNullable(b).orElseThrow(() ->
            new NullPointerException()
        );

    }
    public String b(){
        System.out.println(55555);
        return "sdcsdc";
    }
}
