package com.xiayu.java.socket;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author: starc
 * @date: 2019/3/31
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(55533);
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket socket = serverSocket.accept();
                System.out.println("远程主机地址：" + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("谢谢连接我：" + socket.getLocalSocketAddress() + "\nGoodbye!");
                in.close();
                out.close();
                socket.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        serverSocket.close();
    }

    @Test
    public void client() {
        String serverName = "127.0.0.1";
        int port = 55533;
        try {
            System.out.println("连接到主机：" + serverName + ",端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址:" + client.getRemoteSocketAddress());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF("Hello from " + client.getLocalSocketAddress());
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            System.out.println("服务器响应：" + dataInputStream.readUTF());
            outputStream.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
