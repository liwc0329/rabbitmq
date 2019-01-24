package com.g7go.rabbitmq.common.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout 就是我们熟悉的广播模式或者订阅模式，
 * 给Fanout交换机发送消息
 * 绑定了这个交换机的所有队列都收到这个消息。
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 15:18$
 * @Version: 1.0
 */

@Configuration
public class FanoutRabbitConfig {


    public final static String FANOUT_MESSAGE = "fanoutMessageName";
    public final static String FANOUT_MESSAGE2 = "fanoutMessageName2";
    public final static String FANOUT_MESSAGE3 = "fanoutMessageName3";

    public final static String FANOUT_EXCHANGE = "fanoutExchange";


    @Bean
    public Queue fanoutMessage() {
        return new Queue(FANOUT_MESSAGE);
    }

    @Bean
    public Queue fanoutMessage2() {
        return new Queue(FANOUT_MESSAGE2);
    }

    @Bean
    public Queue fanoutMessage3() {
        return new Queue(FANOUT_MESSAGE3);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    Binding bindingExchange1(Queue fanoutMessage, FanoutExchange fanout) {
        return BindingBuilder.bind(fanoutMessage).to(fanout);
    }

    @Bean
    Binding bindingExchange2(Queue fanoutMessage2, FanoutExchange fanout) {
        return BindingBuilder.bind(fanoutMessage2).to(fanout);
    }

    @Bean
    Binding bindingExchange3(Queue fanoutMessage3, FanoutExchange fanout) {
        return BindingBuilder.bind(fanoutMessage3).to(fanout);
    }

}
