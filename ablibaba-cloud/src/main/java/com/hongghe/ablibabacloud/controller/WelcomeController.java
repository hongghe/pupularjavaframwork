package com.hongghe.ablibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hongghe @date: 2019-01-13 14:47
 */
@Slf4j
@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    /**
     * Greeting index of api.
     */
    @RequestMapping(value = "greeting")
    public String greetingHello(HttpServletRequest requestm, HttpServletResponse response) {
        return response.encodeRedirectURL("/welcome.html");
    }
}
