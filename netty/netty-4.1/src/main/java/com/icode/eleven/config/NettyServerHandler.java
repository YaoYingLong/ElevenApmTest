package com.icode.eleven.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当客户端连接服务器完成就会触发该方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接通道建立完成");
    }

    /**
     * 读取客户端发送的数据
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @param msg 就是客户端发送的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 将msg转成一个ByteBuf，类似NIO的ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("收到客户端的消息:" + buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) { // 数据读取完毕处理方法
        ByteBuf buf = Unpooled.copiedBuffer("HelloClient".getBytes(CharsetUtil.UTF_8));
        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close(); // 处理异常, 一般是需要关闭通道
    }
}
