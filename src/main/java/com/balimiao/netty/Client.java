package com.balimiao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @Description: TODO
 * @Author zhushaopeng
 * @Date 2020/10/23
 **/
public class Client {

    public static void main(String[] args) throws Exception {
//            客户端要做那些事情?1:发送消息到服务端,2:接受发送的消息
        //创建下城组
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        //创建客户端
        NioSocketChannel client = new NioSocketChannel();
        //注册多路复用器
        thread.register(client); //epoll_ctr(5,ADD,3)

        //添加可读事件处理器,用来接受服务端的写过来的数据
        client.pipeline().addLast(new MyHandler());

        ChannelFuture connect = client.connect(new InetSocketAddress(9999)); //异步建立
        ChannelFuture sync = connect.sync();

        ByteBuf byteBuf = Unpooled.copiedBuffer("hello service".getBytes());
        ChannelFuture send = client.writeAndFlush(byteBuf); //异步发送
        send.sync();

        //保持连接,如果server关闭了,则这行代码会执行
        sync.channel().closeFuture().sync();

        System.out.println(1111);
    }

}

 class MyHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client registered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        CharSequence charSequence = buf.getCharSequence(0, buf.readableBytes(), CharsetUtil.UTF_8);
        System.out.println(charSequence);
//        ctx.writeAndFlush(buf);
    }
}
