package com.hongghe.ablibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hongghe @date: 2019-01-13 16:07
 */
@Slf4j
@RestController
@RequestMapping(path = "/exception")
public class ExceptionController {

    /**
     * The not found index.html
     */
    @RequestMapping(value = "404")
    public String notFound(HttpServletRequest request, HttpServletResponse response) {
        return response.encodeRedirectURL("/404.html");
    }

    /**
     * The server error server.html
     */
    @RequestMapping(value = "500")
    public String serverError(HttpServletRequest request, HttpServletResponse response) {
        return response.encodeRedirectURL("/500.html");
    }
}
