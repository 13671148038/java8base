package com.balimiao.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhushaopeng
 * @Date 2020/8/19
 **/
public class SocketClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8022));
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        buffer.put("1".getBytes());
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            socketChannel.write(buffer);
        }
    }
}
