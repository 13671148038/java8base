package com.balimiao.socket.MyNetty;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class SelectorThread implements Runnable {

    private Selector selector;


    private LinkedBlockingQueue<Channel> channels = new LinkedBlockingQueue<>();


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
                int num = selector.select();  //会阻塞   wakeup()
                if (num > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    if (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        }
                    }
                }

                if (!channels.isEmpty()) {
                    Channel channel = channels.take();
                    if (channel instanceof ServerSocketChannel) {
                        ((ServerSocketChannel) channel).register(selector, SelectionKey.OP_ACCEPT);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.clear();
        int read;
        while (true) {
            try {
                read = client.read(buffer);
                if (read > 0) {
                    System.out.println(new String(buffer.array()));
                    buffer.flip();
                    client.write(buffer);
                } else if (read == 0) {
                    break;
                } else if (read == -1) {
                    client.close();
                    break;
                }
            } catch (Exception e) {

            }
        }
    }


    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public LinkedBlockingQueue<Channel> getChannels() {
        return channels;
    }

    public void setChannels(LinkedBlockingQueue<Channel> channels) {
        this.channels = channels;
    }
}
