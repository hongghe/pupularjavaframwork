package com.hongghe.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-09 16:25
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserInformationController {

    @RequestMapping(value = "name")
    public String getUserName() {
        log.info("user name");
        return "name";
    }
}
