package com.code.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    /***
     * durable : 브로커(exchange + queue)가 재시작 될 때 남아 있는지 여부
     * - true -> 재시작해도 유지가능
     * - false -> 재시작하면 사라집니다.
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue("queue-01", false);
    }

    /***
     * # eXchange 모드
     * + Direct : bindKey = eXchange 같을때 전달
     * + Topic : bindKey, eXchange 일부 패턴이 같을때 전달
     * + Fanout : 전체 전달
     * @return
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("exchange-01");
    }

    /***
     * Exchange가 Queue에게 메시지를 전달하기 위한 룰
     * binding key 설정은 exchange가 Direct, Topic 일때 필요
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("binding_key");
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                  MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
