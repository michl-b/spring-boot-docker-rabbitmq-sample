package de.michlb.sample.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Configuration of RabbitMQ handling
 *
 * @author Michael Bartsch
 */
@Configuration
public class RabbitMqConfig implements RabbitListenerConfigurer {

    @Bean
    Queue dataQueue() {
        return new Queue("data-queue", false);
    }

    @Bean
    Queue productQueue() {
        return new Queue("product-queue", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("michlb-sample-exchange:sample");
    }

    @Bean
    Binding dataBinding(@Qualifier("dataQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("data");
    }

    @Bean
    Binding productBinding(@Qualifier("productQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("product");
    }

    @Bean
    MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }

    /**
     * give Jackson ObjetMapper to RabbitMq for JSON Mapping
     *
     * @return
     */
    @Bean
    DefaultMessageHandlerMethodFactory jsonMessageHandlerMethod() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(jackson2Converter());

        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(jsonMessageHandlerMethod());
    }
}
