package com.balimiao;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 运算符
 * @Author zhushaopeng
 * @Date 2019/10/29
 **/
public class Operator {
    @Test
    public void a() {
        Double aa = 555D;
        final String format = String.format("%.0f", aa);
        System.out.println(format);
    }
    @Test
    public void bb() {
        List<Integer> integers = Arrays.asList(1, 2, 4, 5);
        List<Integer> collect = integers.stream().filter(c -> false).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void cc() {
        Double tempDrugstoreDistance = 10350.0 / 1000D;
        System.out.println(tempDrugstoreDistance);
        String format = String.format("%.1f", tempDrugstoreDistance);
        System.out.println(format);
    }
}
