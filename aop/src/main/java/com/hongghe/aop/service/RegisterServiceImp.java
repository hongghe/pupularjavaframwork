package com.hongghe.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: hongghe @date: 2019-01-15 18:23
 */
@Slf4j
@Service
public class RegisterServiceImp implements RegisterService {

    @Override
    public boolean register(String mobile, String password) {
        return false;
    }
}
