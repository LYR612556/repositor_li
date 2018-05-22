package com.netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * 异步时间服务器处理类
 * created by liyurong
 **/
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();//创建异步服务端通道
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));//绑定通道监听的端口
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        latch = new CountDownLatch(1);//再完成一组正在执行的操作之前，允许当前的线程一直阻塞
        doAccept();//接收客户端的连接
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept() {
        asynchronousServerSocketChannel.accept(this,
                new AcceptCompletionHandler());//AcceptCompletionHandler用于接收accept操作成功的通知消息
    }

}