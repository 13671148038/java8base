package com.balimiao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * String 的 split方法会将空的值进行自动删除,如:"1,2,,,,"  调用split 方法后的数组的长度是2.value的值是:1和2
     */
    @Test
    public void shouldAnswerWithTrue() {
        String ids = "1,2,3,4,54,5,";
        String[] split = ids.split(",");
        Stream.of(split).forEach(c -> System.out.println(c + "======="));
        System.out.println(split.length);
    }

    @Test
    public void aaa() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 3);
    }

    @Test
    public void bbbb() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(c -> c, Function.identity()));
        collect.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
