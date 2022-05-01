package com.xf.rocketmqtencentcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @program: xf-tools-springboot
 * @description: 实现类
 * @author: xf
 * @create: 2022-05-01 17:19
 **/
@Slf4j
@Service
public class RocketMqServiceImpl implements RocketMqService{

    // 需要使用topic全称，所以进行topic名称的拼接，也可以自己设置  格式：namespace全称%topic名称
    @Value("${rocketmq.namespace}%${rocketmq.producer1.topic}")
    private String topic;

    //注入rocketmq模板对象
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Override
    public String syncSend(String message, String tags) {
        //获取队列主题名称
        String destination  = StringUtils.isBlank(tags)? topic: topic + ":" +tags;
        try{
            //发送同步消息
            rocketMQTemplate.syncSend(destination, MessageBuilder.withPayload(message)
                    .setHeader(MessageConst.PROPERTY_KEYS, "miss-test").build());
        }catch (Exception e){
            log.error("发送消息失败", e);
        }
        return "消息发送成功";
    }
}
