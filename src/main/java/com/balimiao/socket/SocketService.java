package com.balimiao.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Author zhushaopeng
 * @Date 2020/8/19
 **/
public class SocketService {

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress("localhost", 8022));
        final SocketChannel accept = serverSocketChannel.accept();
        final ByteBuffer allocate = ByteBuffer.allocate(100);
        accept.read(allocate);
        CharBuffer charBuffer = Charset.forName("UTF-8").newDecoder().decode(allocate);
        System.out.println(charBuffer.toString() + "=======================");
        serverSocketChannel.close();

    }

}
