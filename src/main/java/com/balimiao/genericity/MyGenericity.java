package com.balimiao.genericity;

/**
 * @Description: 泛型反方demo
 * @Author zhushaopeng
 * @Date 2019/9/4
 **/
public class MyGenericity {

    private MyGenericity() {}

    public static <T> T getString(T t) {
        return t;
    }
}
