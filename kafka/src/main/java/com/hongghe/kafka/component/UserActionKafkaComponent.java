package com.hongghe.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-24 19:30
 */
@Slf4j
@Profile("kafka_user_action")
@Component
public class UserActionKafkaComponent {

    @KafkaListener(topics = "")
    public String handle(String context) {
        return context;
    }
}
