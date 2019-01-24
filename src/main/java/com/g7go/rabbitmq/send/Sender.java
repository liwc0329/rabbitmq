package com.g7go.rabbitmq.send;

import com.g7go.rabbitmq.common.config.DirectRabbitConfig;
import com.g7go.rabbitmq.common.config.FanoutRabbitConfig;
import com.g7go.rabbitmq.common.config.HeaderRabbitConfig;
import com.g7go.rabbitmq.common.config.TopicRabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送消息
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 14:51$
 * @Version: 1.0
 */

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * Direct模式
     */
    public void send() {
        String context = "hello";
        this.rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECT_QUEUE, context);
    }

    /**
     * Topic模式
     */
    public void send2() {
        String context = "hello";
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, TopicRabbitConfig.MESSAGE, context);
    }

    /**
     * Topic模式
     */
    public void send3() {
        String context = "hello";
        this.rabbitTemplate.convertAndSend(TopicRabbitConfig.TOPIC_EXCHANGE, TopicRabbitConfig.MESSAGE2, context);
    }

    /**
     * Fanout模式
     */
    public void send4() {
        String context = "hello";
        this.rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE, "", context);
    }

    /**
     * Header模式
     */
    public void send5() {
        String context = "hello";
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value1");
        properties.setHeader("header2", "value2");
        Message obj = new Message(context.getBytes(), properties);
        this.rabbitTemplate.convertAndSend(HeaderRabbitConfig.HEADER_EXCHANGE, "", obj);
    }


}
