package com.balimiao.util;

public class IntegerUtil {

    public static boolean isNull(Integer i) {
        return i == null;
    }

    public static boolean isNotNull(Integer i) {
        return !isNull(i);
    }

    public static boolean isNullOrZero(Integer i) {
        return isNull(i) || i.equals(0);
    }

    public static boolean isNotNullAndNotZero(Integer i) {
        return isNotNull(i) && !i.equals(0);
    }

}
