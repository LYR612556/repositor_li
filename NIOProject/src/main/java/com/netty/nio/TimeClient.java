package com.netty.nio;

/**
 * NIO的客户端
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
        //通过TimeClientHandle来处理异步连接和读写操作
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
                .start();
    }
}