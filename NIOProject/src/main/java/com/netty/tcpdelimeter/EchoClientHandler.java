package com.netty.tcpdelimeter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端处理器类，使用分隔符解码器
 * created by liyurong
 **/
public class EchoClientHandler extends ChannelHandlerAdapter {

    private int counter;

    static final String ECHO_REQ = "Hi, liming. Welcome to Netty.$_";

    /**
     * Creates a client-side handler.
     */
    public EchoClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // ByteBuf buf = UnpooledByteBufAllocator.DEFAULT.buffer(ECHO_REQ
        // .getBytes().length);
        // buf.writeBytes(ECHO_REQ.getBytes());
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("This is " + ++counter + " times receive server : ["
                + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}