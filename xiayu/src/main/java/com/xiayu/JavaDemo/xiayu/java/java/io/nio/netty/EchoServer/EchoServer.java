package com.xiayu.JavaDemo.xiayu.java.java.io.nio.netty.EchoServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 所有的Netty服务器都需要有以下两部分.
 *  1.至少一个ChannelHandler-该组件实现了
 *    服务器对从客户端接受的数据的处理,即它的业务逻辑
 *  2.引导-这是配置服务器的启动代码.至少,它会将服务器绑定到它要监听连接请求的端口上
 * @author: starc
 * @date: 2019/9/2
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //1.创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //2.创建ServerBootStrap
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    //3.指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    //4.使用指定端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //5.添加一个EchoServerHandler到子Channel的ChannelPileLine
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            //6.异步地绑定服务器；调用sync()方法阻塞等待直到绑定完成
            ChannelFuture future = bootstrap.bind().sync();
            //7.获取Channel的CloseFuture，并且阻塞当前线程直到它完成
            future.channel().closeFuture().sync();
        } finally {
            //8.关闭EventLoopGroup,释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(9454).start();
    }
}
