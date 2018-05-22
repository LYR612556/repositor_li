package com.netty.aio;

import java.io.IOException;

/**
 * AIO时间服务器服务端
 * created by liyurong
 **/
public class TimeServer {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        //创建异步的时间服务器处理类
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        //创建线程，执行异步时间服务器处理类的方法
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}