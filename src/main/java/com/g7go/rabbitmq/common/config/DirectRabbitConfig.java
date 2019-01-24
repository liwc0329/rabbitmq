package com.g7go.rabbitmq.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 普通发送Direct模式
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 14:49$
 * @Version: 1.0
 */
@Configuration
public class DirectRabbitConfig {

    public final static String DIRECT_QUEUE = "directQueueName";

    /**
     * 普通发送Direct模式
     *
     * @return
     */
    @Bean
    public Queue DirectQueue() {
        return new Queue(DIRECT_QUEUE, true);
    }

}

