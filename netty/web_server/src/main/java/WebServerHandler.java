package com.alex.netty.ws;

import io.netty.channel.ChannelHandler.*;
import io.netty.handler.codec.http.*;
import io.netty.channel.*;
import io.netty.buffer.*;
import io.netty.util.*;

@Sharable
public class WebServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest content = (FullHttpRequest) msg;
            // ByteBuf buf = content.content();
            // String requestInfo = buf.toString(io.netty.util.CharsetUtil.UTF_8);
            // buf.release();
            // System.out.println("http request：" + requestInfo);
            // ctx.write(requestInfo);
            String uri = content.uri();
            System.out.println("uri：" + uri);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}