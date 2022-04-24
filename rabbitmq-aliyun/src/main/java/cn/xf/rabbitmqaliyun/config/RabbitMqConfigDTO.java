package cn.xf.rabbitmqaliyun.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @program: xf-tools-springboot
 * @description: rabbitmq aliyun config
 * @author: xf
 * @create: 2022-04-17 12:01
 **/
@Configuration
@ConfigurationProperties("aliyun.rabbitmq")
@Data
public class RabbitMqConfigDTO {

    /**
     * 账户密匙key
     */
    private String accessKey;

    /**
     * 账户密匙
     */
    private String accessKeySecret;

    /**
     *  静态用户名
     */
    private String username;

    /**
     * 静态用户名密码
     */
    private String password;

    /**
     * 虚拟机名称
     */
    private String vHost;

    /**
     * 交换机名
     */
    private String exchange;

    /**
     * 交换机类型
     */
    private String exType;

    /**
     * 队列名
     */
    private String queue;

    /**
     * 绑定规则key
     */
    private String BindingKey;

    /**
     * 接入点地址
     */
    private String host;


}
