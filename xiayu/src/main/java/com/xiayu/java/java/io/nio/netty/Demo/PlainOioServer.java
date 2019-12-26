package com.xiayu.java.java.io.nio.netty.Demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 未使用Netty的阻塞网络编程
 * @author: test_
 * @date: 2019/9/5
 */
public class PlainOioServer {
    public void server(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        try {
            for(;;) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(
                        "Accept connection from " + clientSocket
                );
                new Thread(() -> {
                    OutputStream outputStream;
                    try {
                        outputStream = clientSocket.getOutputStream();
                        outputStream.write("hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        outputStream.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
