package com.balimiao.myreflect;

import com.balimiao.pojo.UserVisitMsg;

import java.lang.reflect.Field;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.balimiao.pojo.UserVisitMsg");
        Object o = clazz.newInstance();
        Field userId = clazz.getDeclaredField("userId");
        userId.setAccessible(true);
        userId.set(o, 121212122L);
        UserVisitMsg userVisitMsg = (UserVisitMsg) o;
        Long userId1 = userVisitMsg.getUserId();
        System.out.println(userId1);

    }


}
