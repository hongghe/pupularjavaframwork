package com.hongghe.dubboconsumer.controller;

import com.hongghe.dubboconsumer.service.HelloConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-03-18 17:17
 */
@Slf4j
@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    private HelloConsumerService helloConsumerService;

    @RequestMapping(value = "world")
    public Object hello() {
        return this.helloConsumerService.hello();
    }
}
