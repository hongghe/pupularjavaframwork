package com.hongghe.springbootweb.domain;

import lombok.Data;

import javax.servlet.http.Cookie;

/**
 * @author: hongghe @date: 2019-01-13 17:17
 */
@Data
public class HttpRequestEntity {
    private Cookie[] cookie;
    private String requestMethod;
}
