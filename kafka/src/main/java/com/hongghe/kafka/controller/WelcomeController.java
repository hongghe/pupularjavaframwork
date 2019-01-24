package com.hongghe.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-24 19:28
 */
@Slf4j
@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @RequestMapping(value = "hello")
    public String hello() {
        return "hello";
    }
}
