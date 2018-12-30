package com.hongghe.dubboconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hongghe.provider.service.HelloProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author hongghe 2018/12/30
 */
@Slf4j
@Service
public class HelloConsumerService {

    @Reference(version = "1.0.0")
    public HelloProviderService helloService;

    @PostConstruct
    public void init() {
        helloService.sayHello();
    }
}


