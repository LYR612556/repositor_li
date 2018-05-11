package com.netty.pio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 伪异步式I/O的客户端，与同步阻塞式I/O相同
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
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);//建立TCP连接，设置请求的服务器端
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));//输入流
            out = new PrintWriter(socket.getOutputStream(), true);//输出流
            out.println("QUERY TIME ORDER");//发送请求到输出流
            System.out.println("Send order 2 server succeed.");
            String resp = in.readLine();//从输入流中读取响应
            System.out.println("Now is : " + resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//关闭输入输出流和套接字
            if (out != null) {
                out.close();
                out = null;
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}