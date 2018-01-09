package com.alex.netty.ws;

import io.netty.channel.socket.nio.*;
import io.netty.channel.socket.*;
import io.netty.channel.nio.*;
import io.netty.bootstrap.*;
import io.netty.channel.*;
import java.net.*;

public class WebServer {
    private final int port;

    public WebServer(int port) {
        this.port = port;
    }

    public static void main(String[] args)
        throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: "+ WebServer.class.getSimpleName()+" <port>" );
            return;
        }
        int port = Integer.parseInt(args[0]);
        new WebServer(port).start();
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
             .channel(NioServerSocketChannel.class)
             .localAddress(new InetSocketAddress(port))
             .childHandler(new WebServerChannelInitializer());

            ChannelFuture f = b.bind().sync();
            System.out.println("listening on: " + f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}