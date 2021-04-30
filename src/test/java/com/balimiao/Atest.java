package com.balimiao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Atest {
    @Test
    public void aa() {

        List<Integer> integers = Arrays.asList(2);
        IntSummaryStatistics collect = integers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(collect);

    }

    @Test
    public void aa3() {
        Integer a = 116104101;
        Integer b = 454534;
        Integer c = 1161423350;
        Integer d = 1164546104;
        Integer f = 1134246104;
        List<Integer> list = Arrays.asList(a, b, c, d, f);
        list.stream().peek(ee -> System.out.println(ee));
        System.out.println(222 + "" + 11 + 434);
        String version = "3.4.5";
        String[] versionNumArr = version.split("\\.");
        // 主版本号
        int majorVersionNum = Integer.parseInt(versionNumArr[0]);
        // 次版本号
        int minorVersionNum = Integer.parseInt(versionNumArr[1]);
        // 子版本号
        int lastVersionNum = Integer.parseInt(versionNumArr[2]);

        System.out.println(majorVersionNum * 10000 + minorVersionNum * 100 + lastVersionNum);

    }

}
