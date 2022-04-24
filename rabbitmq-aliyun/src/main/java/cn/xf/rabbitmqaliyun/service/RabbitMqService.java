package cn.xf.rabbitmqaliyun.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xf-tools-springboot
 * @description: service
 * @author: xf
 * @create: 2022-04-17 12:15
 **/
public interface RabbitMqService {

    /**
     * 发送mq消息
     * @return
     */
    String sendMessage() throws IOException, TimeoutException;

    String consumeMessage() throws IOException, TimeoutException;
}
