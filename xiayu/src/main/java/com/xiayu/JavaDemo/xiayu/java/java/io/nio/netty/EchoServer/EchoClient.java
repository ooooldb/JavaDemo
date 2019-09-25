package com.xiayu.JavaDemo.xiayu.java.java.io.nio.netty.EchoServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author: test_
 * @date: 2019/9/3
 */
public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            //1.创建BootStrap
            Bootstrap bootstrap = new Bootstrap();
            //2.指定EventLoopGroup以处理客户端事件;需要适用于NIO的实现
            bootstrap.group(group)
                    //3.适用于NIO传输的Channel类型
                    .channel(NioSocketChannel.class)
                    //4.设置服务器的InetSocketAddress
                    .remoteAddress(new InetSocketAddress(host,port))
                    //5.在创建Channel时,向ChannelPipe
                    //  line中添加一个EchoClientHandler实例
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            //6.连接到远程节点,阻塞等待直到连接完成
            ChannelFuture f = bootstrap.connect().sync();
            //7.阻塞,直到Channel关闭
            f.channel().closeFuture().sync();
        } finally {
            //8.关闭线程池并且释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("localhost", 9454).start();
    }
}
