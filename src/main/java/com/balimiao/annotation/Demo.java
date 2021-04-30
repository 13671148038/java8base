package com.balimiao.annotation;

import java.lang.reflect.Field;

/**
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
        //获取类名
        String simpleName = userClass.getSimpleName().toLowerCase();
        System.out.println("simpleName:" + simpleName);
        //获取类上面的注解
        MyAnnotation classAnnotation = userClass.getAnnotation(MyAnnotation.class);
        //获取注解参数值
        System.out.println("indexName:" + classAnnotation.indexName());

        //获取类中全部的变量
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            System.out.println("name:" + name);
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            String methodName = annotation.methodName();
            String propert = annotation.propert();
            System.out.println("methodName:" + methodName);
            System.out.println(propert);
            Class aClass = user.getClass();
            Object invoke = aClass.getMethod(methodName).invoke(user);
            System.out.println(invoke);
        }
    }

}
