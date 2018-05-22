package com.netty.basicnetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 时间服务器服务端处理类，对网络事件进行读写操作
 * created by liyurong
 **/
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        /**
         * ByteBuf类似于java.io.ByteBuffer对象，通过ByteBuf的readableBytes方法可以获取缓冲区可读的字节数，
         * 根据可读的字节数创建byte数组，通过ByteBuf的readBytes方法将缓冲区中的字节数组复制到新建的byte数组中
         */
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        //获取请求消息
        String body = new String(req, "UTF-8");
        System.out.println("The time server receive order : " + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
                System.currentTimeMillis()).toString() : "BAD ORDER";
        //将响应消息封装到缓冲区
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //ChannelHandlerContext的write方法异步发送应答消息给客户端
        //write方法只是把待发送的消息放到发送缓存数组中
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //flush方法将消息发送队列中的消息写入到ScoketChannel中发送给对方
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}