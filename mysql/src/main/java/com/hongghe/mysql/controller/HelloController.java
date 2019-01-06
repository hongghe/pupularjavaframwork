package com.hongghe.mysql.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-06 16:43
 */
@Slf4j
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "hello")
    public String getHello() {
        return "hello";
    }
}
