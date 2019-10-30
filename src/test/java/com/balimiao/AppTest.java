package com.balimiao;

import org.junit.Test;

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
        String ids = " 1 , 2  , 3, 4 ,54 , 5 ,";
        String replace = ids.replaceAll(" ", "");
        System.out.println(replace);
    }
}
