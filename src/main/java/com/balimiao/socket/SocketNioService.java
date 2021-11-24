package com.balimiao.socket;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhushaopeng
 * @Date 2020/8/19
 **/
public class SocketNioService {


    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> socketChannels = new LinkedList<>();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(8022));
        serverSocketChannel.configureBlocking(false);  //重点
//        serverSocketChannel.setOption(StandardSocketOptions.TCP_NODELAY, Boolean.FALSE);

        while (true) {
            TimeUnit.SECONDS.sleep(1);
            SocketChannel client = serverSocketChannel.accept();
            if (client == null) {
                System.out.println("client null.....");
            } else {
                client.configureBlocking(false);  //重点
                int port = client.socket().getPort();
                System.out.println("client port :" + port);
                socketChannels.add(client);
            }
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel c : socketChannels) {
                TimeUnit.SECONDS.sleep(10);
                int num = c.read(byteBuffer);
                while (num > 0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    byteBuffer.get(bytes);
                    String string = new String(bytes);
                    System.out.println(c.socket().getPort() + ":" + string);
                    byteBuffer.clear();
                }
            }
        }
    }

}
