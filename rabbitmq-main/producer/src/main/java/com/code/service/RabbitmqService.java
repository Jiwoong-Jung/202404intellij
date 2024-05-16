package com.code.service;

import com.code.vo.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.bindkey}")
    private String bindKey;

    public void addQueue(Message message){
        rabbitTemplate.convertAndSend(exchange, bindKey, message);
    }

}
