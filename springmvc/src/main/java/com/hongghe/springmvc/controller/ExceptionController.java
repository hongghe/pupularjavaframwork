package com.hongghe.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: hongghe @date: 2019-01-14 15:22
 */
@Slf4j
@RestController
@RequestMapping(path = "/exception")
public class ExceptionController {

    @RequestMapping(value = "404")
    public void notFound(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        response.sendRedirect("/404.html");
    }

    @RequestMapping(value = "500")
    public void serverError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/500.html");
    }
}
