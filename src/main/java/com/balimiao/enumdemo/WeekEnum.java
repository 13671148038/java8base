package com.balimiao.enumdemo;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/10/24
 **/
public enum WeekEnum {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private Integer value;

    WeekEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
