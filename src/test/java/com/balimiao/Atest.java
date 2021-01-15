package com.balimiao;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Atest {
    @Test
    public void aa() {

        List<Integer> integers = Arrays.asList(2, 3, 4, 5);
        Integer reduce = integers.stream().reduce(1, Integer::sum);
        System.out.println(reduce);

    }

    @Test
    public void aa3() {
    }

}
