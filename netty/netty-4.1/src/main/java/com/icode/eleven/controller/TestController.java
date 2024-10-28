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
@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping("/index")
    public String testIndex() throws InterruptedException {
        return "testIndex";
    }

}
