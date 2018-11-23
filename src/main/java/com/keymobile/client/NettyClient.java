package com.keymobile.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 客户端
 */
public class NettyClient {
    public static void run() {
        //客户端线程组
        EventLoopGroup client = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(client)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new HelloWorldClientHandler());
                        }
                    }).option(ChannelOption.TCP_NODELAY, true);
            //连接通道，存取数据
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8080).sync();
            //往通道写数据，给server获取
            future.channel().writeAndFlush("hi server,I am client");
            //阻塞主线程
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
