package com.xiayu.JavaDemo.xiayu.java.java.io.nio.netty.Demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: test_
 * @date: 2019/9/5
 */
public class PlainNioServer {
    public void server(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        socket.bind(address);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer msg = ByteBuffer.wrap("hi!".getBytes());
        for (; ; ) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        Set<SelectionKey> readyKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = readyKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            iterator.remove();
            try {
                if (next.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) next.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ,
                            msg.duplicate());
                    System.out.println(
                            "accepted connection from " + client
                    );
                    if (next.isWritable()) {
                        SocketChannel client1 = (SocketChannel) next.channel();
                        ByteBuffer buffer = (ByteBuffer) next.attachment();
                        while (buffer.hasRemaining()) {
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client1.close();
                    }
                }

            } catch (IOException e) {
                next.cancel();
                e.printStackTrace();
            }
        }

    }
}
