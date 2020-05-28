package com.balimiao.annotation;

/**
 * @Author zhushaopeng
 * @Date 2020/5/26
 **/
public class User {

    @MyAnnotation(propert = "姓名", methodName = "getName")
    private String name;
    @MyAnnotation(propert = "姓别", methodName = "getSex")
    private String sex;
    @MyAnnotation(propert = "年龄", methodName = "getAge")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
