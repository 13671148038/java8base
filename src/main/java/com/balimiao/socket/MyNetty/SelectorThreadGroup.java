package com.balimiao.socket.MyNetty;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.util.LinkedList;

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
            SelectorThread selectorThread = this.next();
            selectorThread.getChannels().put(server);
            selectorThread.getSelector().wakeup();  //唤醒,如果是阻塞
        } catch (Exception e) {
        }
    }

    private SelectorThread next() {
        SelectorThread selectorThread = selectorThreadLinkedList.removeLast();
        selectorThreadLinkedList.addFirst(selectorThread);
        return selectorThread;
    }


}
