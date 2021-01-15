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
        //定义短信的数量
        BigDecimal smsAmount = new BigDecimal(0);
        //定义短信套餐数量
        Integer num;
        for (int i = 0; i < 2; i++) {
            smsAmount = smsAmount.add(new BigDecimal(5000).multiply(new BigDecimal(4)));
        }
        System.out.println(smsAmount.longValue());
    }

    @Test
    public void cdd() {
        final BigDecimal bigDecimal = new BigDecimal(0.3264).setScale(1, RoundingMode.DOWN);
        System.out.println(bigDecimal);
    }

    @Test
    public void cdddd() {
        BigDecimal bigDecimal = new BigDecimal("0.00");
        System.out.println(bigDecimal.compareTo(new BigDecimal("0.1")));
        System.out.printf(new BigDecimal(1009898).divide(new BigDecimal("100")).setScale(2, RoundingMode.DOWN).toString());
    }
}
