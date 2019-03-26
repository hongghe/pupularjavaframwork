package com.hongghe.rabbitmq.components;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hongghe 2018/12/29
 */
@Component
@RabbitListener(queues = "hellomq")
public class RabbitmqReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("receiver message : " + hello);
    }

}