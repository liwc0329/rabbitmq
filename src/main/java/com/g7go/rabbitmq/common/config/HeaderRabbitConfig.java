package com.g7go.rabbitmq.common.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * key value
 *
 * @Author: Mr_li
 * @CreateDate: 2019-01-24$ 20:19$
 * @Version: 1.0
 */
@Configuration
public class HeaderRabbitConfig {

    public final static String HEADER_MESSAGE = "headerMessageName";

    public final static String HEADER_EXCHANGE = "headersExchange";


    @Bean
    public Queue headerMessage() {
        return new Queue(HEADER_MESSAGE);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange(HEADER_EXCHANGE);
    }

    @Bean
    Binding bindingExchange(Queue headerMessage, HeadersExchange header) {
        Map<String, Object> map = new HashMap<>();
        map.put("header1", "value1");
        map.put("header2", "value2");
        return BindingBuilder.bind(headerMessage).to(header).whereAll(map).match();
    }
}
