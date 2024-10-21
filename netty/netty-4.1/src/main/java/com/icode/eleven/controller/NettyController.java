package com.icode.eleven.controller;

import com.icode.eleven.config.NettyClient;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author by YingLong on 2024/9/24
 */
@RequestMapping("/netty")
@RestController
public class NettyController {

    @RequestMapping("/index")
    public String redisTest() throws InterruptedException {
        ChannelFuture channelFuture = new NettyClient().clientInit();
        channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer("Hello, server123123123!", UTF_8));
//        channelFuture.channel().closeFuture().sync();
        return "nettyTest";
    }

}
