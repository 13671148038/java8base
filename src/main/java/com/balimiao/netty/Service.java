package com.balimiao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @Author zhushaopeng
 * @Date 2020/10/23
 **/
public class Service {

    private int port;

    public static void main(String[] args) throws Exception {

        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        NioServerSocketChannel server = new NioServerSocketChannel();

        server.pipeline().addLast(new ChannelInit<NioSocketChannel>() {
            @Override
            void addHandler(NioSocketChannel client) {
                ChannelPipeline pipeline = client.pipeline();
                pipeline.addLast(new ReadHandler());
                thread.register(client);
            }
        }); //接受客户端并注册到selector

        thread.register(server);

        ChannelFuture bind = server.bind(new InetSocketAddress(9999));

        bind.sync().channel().closeFuture().sync();

    }

}

@ChannelHandler.Sharable
abstract class ChannelInit<C extends Channel> extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        addHandler((C) ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    }

    abstract void addHandler(C t);
}


class ReadHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println(buf.getCharSequence(0, buf.readableBytes(), CharsetUtil.UTF_8));
    }
}

class acceptHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server registered");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SocketChannel client = (SocketChannel) msg;
        ctx.fireUserEventTriggered(client);
    }
}
