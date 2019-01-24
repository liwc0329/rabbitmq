package com.g7go.rabbitmq.receiver;

import com.g7go.rabbitmq.common.config.DirectRabbitConfig;
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
@RabbitListener(queues = DirectRabbitConfig.DIRECT_QUEUE)
public class DirectReceiver2 {

    @RabbitHandler
    public void process(String obj) {
        System.out.println("DirectReceiver2  : " + obj);
    }

}
