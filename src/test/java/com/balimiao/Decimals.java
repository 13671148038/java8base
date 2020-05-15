package com.balimiao;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Test
    public void b() {
        BigDecimal decimal = new BigDecimal("2020.3625236").
                multiply(new BigDecimal("2020.3625236")). //乘以
                divide(new BigDecimal("2")).  //除以
                add(new BigDecimal("3")).  //加
                subtract(new BigDecimal("62")). //减法
                setScale(2, RoundingMode.HALF_UP); //保留两位小数,四舍五入
        System.out.println(decimal);
        System.out.println(decimal.longValue());
    }
    @Test
    public void c() {
        BigDecimal decimal = new BigDecimal("36256212");
        System.out.println(decimal.doubleValue() == 0.0);
    }
}
