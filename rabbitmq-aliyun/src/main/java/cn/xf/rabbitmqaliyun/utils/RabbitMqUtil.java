package cn.xf.rabbitmqaliyun.utils;

import cn.xf.rabbitmqaliyun.config.RabbitMqConfigDTO;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @program: xf-tools-springboot
 * @description: rabbitMq工具类
 * @author: xf
 * @create: 2022-04-23 08:46
 **/
@Slf4j
@Component
public class RabbitMqUtil {
    
    @Autowired
    private RabbitMqConfigDTO rabbitMqConfigDTO;

    //第三步 建一个静态的本类
    private static RabbitMqUtil rabbitMqUtil;

    //第四步 初始化
    @PostConstruct
    public void init() {
        rabbitMqUtil = this;
    }
    
    
    public static Connection getRabbitConnection(){

        ConnectionFactory factory = new ConnectionFactory();

        //公网接入点
        factory.setHost(rabbitMqUtil.rabbitMqConfigDTO.getHost());
        //静态用户名
        factory.setUsername(rabbitMqUtil.rabbitMqConfigDTO.getUsername());
        //静态密码
        factory.setPassword(rabbitMqUtil.rabbitMqConfigDTO.getPassword());

        //自动恢复
        factory.setAutomaticRecoveryEnabled(true);
        //网络恢复时间
        factory.setNetworkRecoveryInterval(5000);
        //虚拟机名称
        factory.setVirtualHost(rabbitMqUtil.rabbitMqConfigDTO.getVHost());
        //端口
        factory.setPort(5672);
        //连接超时时间
        factory.setConnectionTimeout(30*100);
        //设置握手超时时间
        factory.setHandshakeTimeout(300000000);
        factory.setShutdownTimeout(0);

        //创建连接
        Connection connection = null;
        try {
            connection =factory.newConnection();

        }catch (Exception e){
            log.error("rabbitMq连接异常", e);
        }

        return connection;
    }

    public static Channel getRabbitChannel(Connection connection){

        Channel channel = null;
        try {
            channel = connection.createChannel();
            String exchange = rabbitMqUtil.rabbitMqConfigDTO.getExchange();
            channel.exchangeDeclare(exchange,rabbitMqUtil.rabbitMqConfigDTO.getExType(), true, false,false, null);
            channel.queueDeclare(rabbitMqUtil.rabbitMqConfigDTO.getQueue(), true, false, false, new HashMap<String, Object>());
            channel.queueBind(rabbitMqUtil.rabbitMqConfigDTO.getQueue(), rabbitMqUtil.rabbitMqConfigDTO.getExchange(), rabbitMqUtil.rabbitMqConfigDTO.getBindingKey());


        }catch (Exception e){
            log.error("创建rabbitMq通道异常", e);
        }

        return channel;
    }

}
