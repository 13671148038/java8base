package com.balimiao.annotation;

import java.lang.reflect.Field;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2020/5/26
 **/
public class Demo {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setAge(2);
        user.setName("小明");
        user.setSex("男");
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            String methodName = annotation.methodName();
            String propert = annotation.propert();
            System.out.println(methodName);
            System.out.println(propert);
            Class aClass = user.getClass();
            Object invoke = aClass.getMethod(methodName).invoke(user);
            System.out.println(invoke);
        }
    }

}
