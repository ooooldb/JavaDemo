package com.xiayu.java.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: starc
 * @date: 2019/3/31
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //监听指定的端口
        ServerSocket serverSocket = new ServerSocket(55533);
        //server将一直等待连接的到来
        Socket socket = serverSocket.accept();
        //建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接受方一定要统一
            sb.append(new String(bytes, 0, len, "utf8"));
        }
        System.out.println("get message from client:"+sb);
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
    @Test
    public void clientDemo() throws IOException {
        //要连接的服务器ip地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        //与服务端建立连接
        Socket socket = new Socket(host,port);
        //建立连接后获取输出流
        OutputStream outputStream = socket.getOutputStream();
        String str = "甘宁酿勒1";
        outputStream.write(str.getBytes("utf8"));
        outputStream.close();
        socket.close();
    }
}
