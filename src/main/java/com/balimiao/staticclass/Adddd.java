package com.balimiao.staticclass;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/10/24
 **/
public class Adddd {

    public static class Node {

        public static Integer i = 0;

        public static void ddd() {
            i++;
        }
    }


    public void setI() {
        Node.ddd();
    }

    public Integer getI() {
        return Node.i;
    }


    public static void main(String[] args) {
        Adddd adddd = new Adddd();
        adddd.setI();
        System.out.println(adddd.getI());
        Adddd adddd2 = new Adddd();
        System.out.println(adddd2.getI());
    }

}
