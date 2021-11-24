package com.balimiao.socket.MyNetty;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorThread implements Runnable {

    private Selector selector;

    public SelectorThread() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("11111");
                int num = selector.select();
                System.out.println("22222");
                if (num > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    if (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = server.accept();
//            client.register()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }
}
