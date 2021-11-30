package com.balimiao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class Atest {
    @Test
    public void bbbbccc() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binarySearch(arr, 5);
        System.out.println(i);

    }

    //二分法查找
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int startIndex = 0, endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void aa() {
        String aa = "sdc/sdcs";
        int i = aa.lastIndexOf("/");
        String substring = aa.substring(i + 1);
        System.out.println(substring);


    }

}
