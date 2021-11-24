package com.balimiao.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketMultiplexingService {


    public static void main(String[] args) throws Exception {

        //创建,绑定,监听
        ServerSocketChannel server = ServerSocketChannel.open().bind(new InetSocketAddress(8022));
        server.configureBlocking(false);
        //使用多路复用器
        /**
         * 如果是epoll则是调用epoll的create方法
         */
        Selector selector = Selector.open();

        /**
         *server  约等于 listen状态的fd3
         *
         * select,poll:jvm开辟一个数组放进去
         *
         * epoll:epoll_clt(fd3,add,fd4,epollin)
         *
         */
        server.register(selector, SelectionKey.OP_ACCEPT);

        /**
         * select,poll 其实 内核的select(fd4),poll(fd4)
         * epoll:调用epoll_wait()
         * 参数可带时间:没有时间0:阻塞,有时间设置一个超时
         */
        while (true) {
            //全部连接
            Set<SelectionKey> keys = selector.keys();
            System.out.println("keys size:" + keys.size());
            while (selector.select(500) > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isAcceptable()) {
                        acceptHandler(next);
                    } else if (next.isWritable()) {
//                    writeHandler
                    } else if (next.isReadable()) {
                        //io thread
                        readHandler(next);
                    }
                }
            }
        }
    }

    public static void readHandler(SelectionKey key) throws Exception {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read;
        while (true) {
            read = client.read(buffer);
            if (read > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
//                    client.register(key.selector(), SelectionKey.OP_WRITE, buffer);
                    client.write(buffer);
                }
            } else if (read == 0) {
                break;
            } else if (read == -1) {
                client.close();
                break;
            }
        }
    }

    public static void acceptHandler(SelectionKey key) throws Exception {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        client.register(Selector.open(), SelectionKey.OP_READ, buffer);
    }
}
