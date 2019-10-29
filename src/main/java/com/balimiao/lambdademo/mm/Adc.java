package com.balimiao.lambdademo.mm;

public class Adc {

    public <T, R> R sdc(MyFunctionInterface<T, R> pa, T t) {
        return pa.reup(t);
    }
}
