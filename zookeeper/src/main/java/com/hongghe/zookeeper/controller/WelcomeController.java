package com.hongghe.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-03-15 14:03
 */
@Slf4j
@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @RequestMapping(value = "hello")
    public String hello(String greeting) {
        System.out.println(greeting);
        return "Hello, man.";
    }
}
