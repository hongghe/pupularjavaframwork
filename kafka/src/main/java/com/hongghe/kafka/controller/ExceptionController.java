package com.hongghe.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: hongghe @date: 2019-01-05 11:09
 */
@Slf4j
@RestController
@RequestMapping(path = "/exception")
public class ExceptionController {

    @RequestMapping(value = "hello", produces = "text/plain")
    public void hello(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.sendRedirect("/hello.html");
    }
}
