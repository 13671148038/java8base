package com.balimiao.staticclass;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2019/10/24
 **/
public class Adddd {
    private Integer aa = 3;

    public static class Node {

        public Integer i = 0;

        public void ddd() {
            i++;
        }

        public Integer getd() {
            return i;
        }
    }


    public void setI() {
        Node node = new Node();
        node.ddd();
    }

    public void getI() {
        Node node = new Node();
        final Integer getd = node.getd();
        System.out.println(getd);
    }


    public static void main(String[] args) {
        Adddd adddd = new Adddd();
        adddd.setI();
        adddd.getI();
        Adddd adddd2 = new Adddd();
        adddd2.getI();
    }

}
