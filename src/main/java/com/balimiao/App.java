package com.balimiao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Map map = new HashMap<>();
            map.put(1, 1);
            Object o = Optional.ofNullable(map.get(2)).orElseThrow(() -> new RuntimeException(""));
            System.out.println(o);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        }catch (RuntimeException e){
            System.out.println("RuntimeException");
        }catch (Exception e){
            System.out.println("Exception");
        }
    }

    public static String aa() {
        System.out.println(1111);
        return "dddd";
    }


}
