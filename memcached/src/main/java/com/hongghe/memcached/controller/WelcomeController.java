package com.hongghe.memcached.controller;

import com.whalin.MemCached.MemCachedClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-14 20:48
 */
@Slf4j
@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @Autowired
    private MemCachedClient memCachedClient;

    @RequestMapping(value = "hello")
    public String hello() {
        memCachedClient.set("hello", "hello", 10000);
        return "hello";
    }
}
