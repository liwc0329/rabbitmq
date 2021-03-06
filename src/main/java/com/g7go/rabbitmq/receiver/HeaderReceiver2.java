package com.g7go.rabbitmq.receiver;

import com.g7go.rabbitmq.common.config.HeaderRabbitConfig;
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
@RabbitListener(queues = HeaderRabbitConfig.HEADER_MESSAGE)
public class HeaderReceiver2 {

    @RabbitHandler
    public void process(byte[] obj) {
        System.out.println("HeaderReceiver2  : " + new String(obj));
    }

}
