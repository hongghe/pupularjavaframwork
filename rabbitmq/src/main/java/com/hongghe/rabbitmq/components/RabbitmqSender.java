package com.hongghe.rabbitmq.components;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author hongghe 2018/12/29
 */
@Component
public class RabbitmqSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hellomq " + new Date();
        System.out.println("send message : " + context);
        this.rabbitTemplate.convertAndSend("hellomq", context);
    }

    @PostConstruct
    public void init() {
        send();
    }

}
