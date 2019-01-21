package com.hongghe.prometheus.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: hongghe @date: 2019-01-21 16:58
 */
@Slf4j
@Service
public class HelloService implements GreetingService {

    @Override
    public String hello(String greeting) {
        return "Hello,World!";
    }

    @Override
    public String response(String key) {
        if (key.isEmpty()) {
            return null;
        }
        return "Hello, response!";
    }

    @Override
    public String confirm(String key) {
        return "Hello,Key";
    }
}
