package com.code.controller;

import com.code.service.RabbitmqService;
import com.code.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    @Autowired
    RabbitmqService rabbitmqService;

    @RequestMapping(value = "/send")
    public Message send(Message message){
        rabbitmqService.addQueue(message);
        return message;
    }
}
