package com.netty.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接收通知回调业务的handler，用于告知服务器端读取请求消息成功
 * created by liyurong
 **/
public class ReadCompletionHandler implements
        CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;//用于读取半包消息和发送应答

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null)
            this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {//读取到消息之后的处理
        attachment.flip();//将limit的位置设置为position，position设置为0，mark=-1
        byte[] body = new byte[attachment.remaining()];//根据缓冲区的可读字节数创建数组
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");//创建请求消息
            System.out.println("The time server receive order : " + req);
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new java.util.Date(
                    System.currentTimeMillis()).toString() : "BAD ORDER";//判断请求消息并处理
            doWrite(currentTime);//发送结果给客户端
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currentTime) {
        if (currentTime != null && currentTime.trim().length() > 0) {//对时间进行校验
            byte[] bytes = (currentTime).getBytes();//将应答消息编码为字符数组
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);//分配缓冲区
            writeBuffer.put(bytes);//发送到缓冲区中
            writeBuffer.flip();
            //调用异步通道的异步write方法
            channel.write(writeBuffer, writeBuffer,
                    new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer buffer) {
                            // 如果没有发送完成，继续发送
                            if (buffer.hasRemaining())
                                channel.write(buffer, buffer, this);
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                channel.close();
                            } catch (IOException e) {
                                // ingnore on close
                            }
                        }
                    });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}