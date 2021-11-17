package com.balimiao.util;

import java.util.List;
import java.util.stream.Collectors;

public class MathUtil {


    public static String getMedian(List<? extends Number> array) {
        int size = array.size();
        //计算中值
        int y = size % 2;
        int c = size / 2;
        Number median;
        if (y == 0 && c == 0) {
            median = 0;
        } else {
            median = array.get(y + c - 1);
        }
        return median.toString();
    }


    /**
     * 标准差
     *
     * @param array
     * @return
     */
    public static double getStandardDeviation(List<? extends Number> array) {
        double average = array.stream().collect(Collectors.summarizingDouble(Number::doubleValue)).getAverage();
        return getStandardDeviation(array, average);
    }

    /**
     * 标准差
     *
     * @param array
     * @return
     */
    public static double getStandardDeviation(List<? extends Number> array, double average) {
        if (array.size() == 1) {
            return array.get(0).doubleValue();
        }
        double sum = 0;
        Number number = array.get(0);
        if (number instanceof Integer) {
            for (int i = 0; i < array.size(); i++) {
                sum += Math.sqrt(((Integer) array.get(i) - average) * ((Integer) array.get(i) - average));
            }
        } else if (number instanceof Double) {
            for (int i = 0; i < array.size(); i++) {
                sum += Math.sqrt(((Double) array.get(i) - average) * ((Double) array.get(i) - average));
            }
        }
        return (sum / (array.size() - 1));
    }

}
