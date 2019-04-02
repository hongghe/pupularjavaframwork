package com.hongghe.rabbitmq.annotations;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-03-26 15:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RabbitMQTopic {
    String topic = "hello";
}
