package com.xf.rocketmqtencentcloud.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @program: xf-tools-springboot
 * @description: 消息消费监听器
 * @author: xf
 * @create: 2022-05-01 17:35
 **/
@Service
@RocketMQMessageListener(
        consumerGroup = "${rocketmq.namespace}%${rocketmq.consumer1.group}",  // 消费组，格式：namespace全称%group名称
        topic = "${rocketmq.namespace}%${rocketmq.consumer1.topic}",// 需要使用topic全称，所以进行topic名称的拼接，也可以自己设置  格式：namespace全称%topic名称
        selectorExpression = "${rocketmq.consumer1.subExpression}" // 订阅表达式, 不配置表示订阅所有消息
)
public class MessageConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {

        System.out.println("开始消费消息：" + s);
    }
}
