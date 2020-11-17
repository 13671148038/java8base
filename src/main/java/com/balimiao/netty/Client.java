package com.balimiao.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2020/10/23
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8999;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            System.out.println(1);
            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)
            System.out.println(2);
            f.channel().writeAndFlush("454564651");
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
            System.out.println(3);
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
