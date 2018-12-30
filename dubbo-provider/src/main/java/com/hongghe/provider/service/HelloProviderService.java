package com.hongghe.provider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hongghe 2018/12/30
 */
@Slf4j
@Component
public class HelloProviderService implements HelloService {

    @Override
    public String sayHello() {
        log.error("[HelloServiceImp]sayHello");
        return "say hello!";
    }
}