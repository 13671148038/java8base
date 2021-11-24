package com.balimiao.socket.MyNetty;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class SelectorThreadGroup {

    private LinkedList<SelectorThread> selectorThreadLinkedList;

    public SelectorThreadGroup(int selectorThreadNum) {
        selectorThreadLinkedList = new LinkedList<>();
        for (int i = 0; i < selectorThreadNum; i++) {
            SelectorThread selectorThread = new SelectorThread();
            selectorThreadLinkedList.addFirst(selectorThread);
            new Thread(selectorThread).start();
        }
    }


    public void bind(int port) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open().bind(new InetSocketAddress(port));
            server.configureBlocking(false);
            SelectorThread selectorThread = next();
            Selector selector = selectorThread.getSelector();
            server.register(selector, SelectionKey.OP_ACCEPT);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("sdcd");
            selector.wakeup();
            System.out.println("jjkhj");
        } catch (Exception e) {
        }
    }

    private SelectorThread next() {
        SelectorThread selectorThread = selectorThreadLinkedList.removeLast();
        selectorThreadLinkedList.addFirst(selectorThread);
        return selectorThread;
    }


}
