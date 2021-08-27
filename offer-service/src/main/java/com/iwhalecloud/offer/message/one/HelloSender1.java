package com.iwhalecloud.offer.message.one;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {

    @Autowired
    private  AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello1 consumer";

        System.out.println("Sender1 : " + sendMsg);

        rabbitTemplate.convertAndSend("helloQueue", sendMsg);

    }
}
