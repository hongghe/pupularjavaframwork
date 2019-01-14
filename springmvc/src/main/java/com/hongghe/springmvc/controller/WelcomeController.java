package com.hongghe.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: hongghe @date: 2019-01-14 14:17
 */
@Slf4j
@RestController
@RequestMapping(path = "welcome")
public class WelcomeController {

    @RequestMapping(value = "hello")
    public void greetingHello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.sendRedirect("/welcome.html");
        } catch (IOException e) {
            new RuntimeException(e);
        }
    }
}
