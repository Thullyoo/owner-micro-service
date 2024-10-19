package com.thullyooo.owner_micro_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_METHOD_1 = "category.create.queue";
    public static final String QUEUE_METHOD_2 = "category.update.queue";
    public static final String QUEUE_METHOD_3 = "category.delete.queue";
    public static final String QUEUE_METHOD_4 = "product.create.queue";
    public static final String QUEUE_METHOD_5 = "product.update.queue";
    public static final String QUEUE_METHOD_6 = "product.delete.queue";

    public static final String EXCHANGE_NAME = "catalog.topic";
    public static final String ROUTING_KEY_METHOD_1 = "category.create";
    public static final String ROUTING_KEY_METHOD_2 = "category.update";
    public static final String ROUTING_KEY_METHOD_3 = "category.delete";
    public static final String ROUTING_KEY_METHOD_4 = "product.create";
    public static final String ROUTING_KEY_METHOD_5 = "product.update";
    public static final String ROUTING_KEY_METHOD_6 = "product.delete";

    @Bean
    public Queue queueMethod1() {
        return new Queue(QUEUE_METHOD_1, true);
    }

    @Bean
    public Queue queueMethod2() {
        return new Queue(QUEUE_METHOD_2, true);
    }

    @Bean
    public Queue queueMethod3() {
        return new Queue(QUEUE_METHOD_3, true);
    }

    @Bean
    public Queue queueMethod4() {
        return new Queue(QUEUE_METHOD_4, true);
    }

    @Bean
    public Queue queueMethod5() {
        return new Queue(QUEUE_METHOD_5, true);
    }

    @Bean
    public Queue queueMethod6() {
        return new Queue(QUEUE_METHOD_6, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingMethod1(Queue queueMethod1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod1()).to(exchange()).with(ROUTING_KEY_METHOD_1);
    }

    @Bean
    public Binding bindingMethod2(Queue queueMethod2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod2).to(exchange).with(ROUTING_KEY_METHOD_2);
    }

    @Bean
    public Binding bindingMethod3(Queue queueMethod3, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod3).to(exchange).with(ROUTING_KEY_METHOD_3);
    }

    @Bean
    public Binding bindingMethod4(Queue queueMethod4, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod4).to(exchange).with(ROUTING_KEY_METHOD_4);
    }

    @Bean
    public Binding bindingMethod5(Queue queueMethod5, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod5).to(exchange).with(ROUTING_KEY_METHOD_5);
    }

    @Bean
    public Binding bindingMethod46(Queue queueMethod6, TopicExchange exchange) {
        return BindingBuilder.bind(queueMethod6).to(exchange).with(ROUTING_KEY_METHOD_6);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
