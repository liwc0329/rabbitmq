package com.g7go.rabbitmq.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic 是RabbitMQ中最灵活的一种方式
 * 可以根据routing_key自由的绑定不同的队列
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 15:04$
 * @Version: 1.0
 */

@Configuration
public class TopicRabbitConfig {

    public final static String MESSAGE = "topic.message";
    public final static String MESSAGE2 = "topic.message2";
    public final static String TOPIC_EXCHANGE = "topicExchange";

    public final static String ROUTING_KEY = "topic.message";
    public final static String ROUTING_KEY2 = "topic.#";

    @Bean
    public Queue queueMessage() {
        return new Queue(MESSAGE, true);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(MESSAGE2, true);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 只能匹配topic.message
     *
     * @param queueMessage
     * @param topic
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topic) {
        return BindingBuilder.bind(queueMessage).to(topic).with(ROUTING_KEY);
    }

    /**
     * topic.message  topic.messages都可以
     *
     * @param queueMessage2
     * @param topic
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange topic) {
        return BindingBuilder.bind(queueMessage2).to(topic).with(ROUTING_KEY2);
    }
}

