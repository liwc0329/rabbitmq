package com.g7go.rabbitmq.receiver;

import com.g7go.rabbitmq.common.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 作用描述
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 14:53$
 * @Version: 1.0
 */

@Component
@RabbitListener(queues = TopicRabbitConfig.MESSAGE2)
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("TopicReceiver2  : " + hello);
    }

}
