package com.xf.rocketmqtencentcloud.service;

/**
 * @program: xf-tools-springboot
 * @description: service
 * @author: xf
 * @create: 2022-05-01 17:18
 **/
public interface RocketMqService {

    String syncSend(String message, String tags);

}
