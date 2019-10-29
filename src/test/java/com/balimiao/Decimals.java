package com.balimiao;

import org.junit.Test;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/10/29
 **/
public class Decimals {
    @Test
    public void a() {
        //小数保留两位小数(自动进行四舍五入)
        Double a = 0.3, b = 2D;
        String format = String.format("%.2f", a);
        System.out.println(format);
        System.out.println(a / b);
        int c = 3, d = 2;
        System.out.println(c / d);
        System.out.println(c % d);
    }
}
