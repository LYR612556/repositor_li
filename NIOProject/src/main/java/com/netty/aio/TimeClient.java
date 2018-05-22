package com.netty.aio;

/**
 * AIO时间服务器客户端
 * created by liyurong
 **/
public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        //在实际项目中，不需要独立的线程创建异步连接对象，因为底层都是通过jdk的系统回调实现的。。。。
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();//通过独立的IO线程创建异步时间服务器客户端Handler

    }
}