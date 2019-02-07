package com.balimiao.lambdademo.mm;

@FunctionalInterface
public interface MyFunctionInterface<T, R> {

    R reup(T t);

}
