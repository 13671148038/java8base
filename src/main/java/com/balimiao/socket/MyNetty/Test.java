package com.balimiao.socket.MyNetty;

public class Test {


    public static void main(String[] args) {
        SelectorThreadGroup selectorThreadGroup = new SelectorThreadGroup(1);
        selectorThreadGroup.bind(9999);
        System.out.println(444);
    }
}
