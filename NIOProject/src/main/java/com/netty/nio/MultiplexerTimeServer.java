package com.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用类，服务器端线程
 * created by liyurong
 **/
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器、绑定监听端口
     *
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            //配置Channel的TCP参数
            serverSocketChannel.configureBlocking(false);//异步非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);//绑定端口，并将backlog设置为1024，表示能够用于处理请求的队列长度
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//将通道注册到Selector，监听SelectionKey.OP_ACCEPT操作位
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);//资源初始化失败则退出
        }
    }

    public void stop() {
        this.stop = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {//循环遍历selector
        while (!stop) {
            try {
                selector.select(1000);//设置休眠时间为1s
                Set<SelectionKey> selectedKeys = selector.selectedKeys();//获取就绪状态的集合
                Iterator<SelectionKey> it = selectedKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {//遍历
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null)
                                key.channel().close();
                        }
                    }
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

        // 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
        if (selector != null)
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void handleInput(SelectionKey key) throws IOException {//处理客户端的请求信息

        if (key.isValid()) {
            // 处理新接入的请求消息
            if (key.isAcceptable()) {//处理请求信息
                // Accept the new connection
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();//获取通道
                SocketChannel sc = ssc.accept();//接收请求并创建SocketChannel实例,完成TCP的三次握手
                sc.configureBlocking(false);//设置异步非阻塞
                // Add the new connection to the selector
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {//读取客户端的请求信息
                // Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);//开辟1K的缓冲区
                int readBytes = sc.read(readBuffer);//读取请求流，read为非阻塞的
                //readBytes>0：读到了字节，对字节进行编解码；=0：没有读到字节，正常场景，忽略；-1：链路已经关闭，需要关闭SocketChannel，释放资源
                if (readBytes > 0) {//读到了码流，对字节进行编解码
                    readBuffer.flip();//将缓冲区当前的limit设置为position，position设置为0，用于后续对缓冲区的读取操作
                    //读取缓冲区（limit - position）的信息并处理
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : "
                            + body);
                    String currentTime = "QUERY TIME ORDER"
                            .equalsIgnoreCase(body) ? new java.util.Date(
                            System.currentTimeMillis()).toString()
                            : "BAD ORDER";
                    //将处理结果写到缓冲区
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    // 对端链路关闭
                    key.cancel();
                    sc.close();
                } else
                    ; // 读到0字节，忽略
            }
        }
    }

    private void doWrite(SocketChannel channel, String response)
            throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            //分配缓冲区
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //将数组数据复制到缓冲区中
            writeBuffer.put(bytes);
            writeBuffer.flip();
            //将缓冲区发送出去
            channel.write(writeBuffer);
        }
    }
}