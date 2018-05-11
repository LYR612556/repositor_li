package com.netty.nio;

import java.io.IOException;

/**
 * NIO创建时间服务器
 * created by liyurong
 **/
public class TimeServer {

    /**
     * @param args
     * @throws IOException
     * ion
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {//设置监听端口
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        //多路复用器，是一个单独的线程，负责轮询多路复用器Selector，可以处理多个客户端的并发接入
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();//执行多路复用器
    }
}