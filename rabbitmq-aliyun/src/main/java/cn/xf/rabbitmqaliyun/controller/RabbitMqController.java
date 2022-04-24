package cn.xf.rabbitmqaliyun.controller;

import cn.xf.rabbitmqaliyun.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xf-tools-springboot
 * @description:
 * @author: xf
 * @create: 2022-04-17 12:15
 **/
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @GetMapping("/sendMessage")
    public String sendMessage() throws IOException, TimeoutException {

        return rabbitMqService.sendMessage();
    }

    @GetMapping("/consumeMessage")
    public String consumeMessage() throws IOException, TimeoutException {

        return rabbitMqService.consumeMessage();
    }
}
