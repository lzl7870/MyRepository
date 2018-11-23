package com.keymobile.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 建立规则
 */
public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端收到新的消息时此方法就被调用，
     * @param ctx 通道处理的上下文信息
     * @param msg 接收的消息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead..");
        System.out.println(ctx.channel().remoteAddress()+"->Server :"+ msg.toString());
        ctx.write("server write"+msg);//服务器写回给client
        ctx.flush();
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
