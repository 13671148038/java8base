package com.balimiao;

import com.balimiao.pojo.UserVisitMsg;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;


@Slf4j
public class Atest {
    @Test
    public void bbbbccc() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binarySearch(arr, 5);
        System.out.println(i);
        Adcsdc adcsdc = new Adcsdc();
        Integer sac = adcsdc.sac(c -> c + 5);
        System.out.println(sac);
        int asdc = 1;
        int asdxcsdc = 1;
        System.out.println(asdc++);
        System.out.println(++asdxcsdc);
    }


    class Adcsdc {

        private Integer a = 9;

        public Integer sac(Function<? super Integer, ? extends Integer> mapper) {
            return mapper.apply(a);
        }


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

        Map<String, String> builder = new LinkedHashMap<>();
        builder.put("姓名", "name");
        builder.put("手机号", "mobile");
        builder.put("性别", "gender");
        builder.put("医院", "organizationName");
        builder.put("职称", "title");
        builder.put("科室", "deptName");
        builder.put("省份", "province");
        builder.put("城市", "city");
        builder.put("区县", "county");
        builder.put("业务名称", "bizName");
        builder.put("来源", "categoryName");
        builder.put("提交时间", "submitTime");

        builder.forEach((key, value) -> {
            System.out.println(key);
        });


    }

}
