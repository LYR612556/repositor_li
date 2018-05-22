package com.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * accept操作的处理类，用于通知异步通道接收完成
 * created by liyurong
 **/
public class AcceptCompletionHandler implements
        CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result,
                          AsyncTimeServerHandler attachment) {
        /**
         * 从attachment获取asynchronousServerSocketChannel通道实例，继续调用accept方法
         * 当调用异步通道的accept方法后，如果有新的客户端连接接入，系统将回调AsyncTimeServerHandler实例的completed方法
         * 表示新的客户端已经成功接入，因为一个异步通道可以接入成千上万个客户端，所以需要继续调用它的accept方法，接收其他的客户端连接，
         * 最终形成一个循环
         */
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        //创建缓冲区接收客户端的请求消息
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * ByteBuffer dst：接收缓冲区，用于从异步通道中读取数据包
         * ByteBuffer attachment：异步通道携带的附件，通知回调的时候作为入参使用
         * CompletionHandler<Integer, ? super ByteBuffer> handler)：接收通知回调的业务handler
         */
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }

}