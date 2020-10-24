package com.balimiao.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author zhushaopeng
 * @Date 2020/8/19
 **/
public class SocketClient {

    public static void main(String[] args) throws IOException {

        final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8022));
        final ByteBuffer allocate = ByteBuffer.allocate(100);
        allocate.put(ByteBuffer.wrap("你好啊啊啊".getBytes()));
        socketChannel.write(allocate);

    }
}
