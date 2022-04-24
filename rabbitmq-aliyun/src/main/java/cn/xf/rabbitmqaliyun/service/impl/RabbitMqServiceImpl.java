package cn.xf.rabbitmqaliyun.service.impl;

import cn.xf.rabbitmqaliyun.config.RabbitMqConfigDTO;
import cn.xf.rabbitmqaliyun.service.RabbitMqService;
import cn.xf.rabbitmqaliyun.utils.RabbitMqUtil;
import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @program: xf-tools-springboot
 * @description:
 * @author: xf
 * @create: 2022-04-17 12:16
 **/
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private RabbitMqConfigDTO rabbitMqConfigDTO;

    @Override
    public String sendMessage() throws IOException {

        Connection connection = RabbitMqUtil.getRabbitConnection();
        Channel channel = RabbitMqUtil.getRabbitChannel(connection);
        //开始发送消息
        for(int i=0; i< 10 ; i++){
            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().messageId(UUID.randomUUID().toString()).build();
            channel.basicPublish(rabbitMqConfigDTO.getExchange(), "BindingKey", true, props,
                    ("消息发送Body"  + i).getBytes(StandardCharsets.UTF_8));

        }
        connection.close();
        return "消息发送成功";

    }

    @Override
    public String consumeMessage() throws IOException, TimeoutException {

        Connection connection = RabbitMqUtil.getRabbitConnection();
        Channel channel = RabbitMqUtil.getRabbitChannel(connection);

        String exchange = rabbitMqConfigDTO.getExchange();
        channel.exchangeDeclare(exchange,rabbitMqConfigDTO.getExType(), true, false,false, null);
        channel.queueDeclare(rabbitMqConfigDTO.getQueue(), true, false, false, new HashMap<String, Object>());
        channel.queueBind(rabbitMqConfigDTO.getQueue(), rabbitMqConfigDTO.getExchange(), rabbitMqConfigDTO.getBindingKey());

        // 开始消费消息。
        channel.basicConsume(rabbitMqConfigDTO.getQueue(), false, "ConsumerTag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                //接收到的消息，进行业务逻辑处理。
                System.out.println("Received： "  + new String(body, StandardCharsets.UTF_8) +  ", deliveryTag: "  + envelope.getDeliveryTag()  + ", messageId: " +  properties.getMessageId());
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        connection.close();

        return "消费成功";
    }



}
