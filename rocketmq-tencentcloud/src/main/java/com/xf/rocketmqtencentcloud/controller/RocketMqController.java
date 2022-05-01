package com.xf.rocketmqtencentcloud.controller;

import com.xf.rocketmqtencentcloud.service.RocketMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xf-tools-springboot
 * @description: rocketMq控制器
 * @author: xf
 * @create: 2022-05-01 17:18
 **/
@RestController
@RequestMapping("rocketMq")
public class RocketMqController {

    @Autowired
    private RocketMqService rocketMqService;

    /**
     * 发送消息
     * @param message 消息体
     * @param tags 消息标签
     * @return
     */
    @GetMapping("/sendMessage")
    public String sendMessage(String message, String tags){

        return rocketMqService.syncSend(message, tags);
    }
}
