package com.alex.netty.ws;

import io.netty.handler.codec.http.*;
import io.netty.channel.socket.*;
import io.netty.channel.*;

public class WebServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("codec", new HttpServerCodec());
        ch.pipeline().addLast("aggregator", new HttpObjectAggregator(512 * 1024));
        ch.pipeline().addLast("handler", new WebServerHandler());
    }
}