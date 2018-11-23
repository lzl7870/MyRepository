package com.keymobile.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void run() {
        //一个NioEventLoopGroup可以用于处理多个channel事件的
        EventLoopGroup boss = new NioEventLoopGroup();//接收连接
        EventLoopGroup worker = new NioEventLoopGroup();//处理接收的连接
        try {
            //启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker);
            //告诉Channel如何获取新的连接，指定使用NIO模式
            bootstrap.channel(NioServerSocketChannel.class);
            //配置channel,把channelHandler安装到channelPipeline中，channelPipeline
            // 是给channelHandler链提供一个API来管理链出站入站的事件流动
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    socketChannel.pipeline().addLast("decoder", new StringDecoder());
                    socketChannel.pipeline().addLast("encoder", new StringEncoder());
                    socketChannel.pipeline().addLast(new HelloWorldServerHandler());
                }
            });
            //引导类的配置信息
            bootstrap.option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
            //绑定接口
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            //阻塞主线程
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new NettyServer(8080).run();
    }
}
