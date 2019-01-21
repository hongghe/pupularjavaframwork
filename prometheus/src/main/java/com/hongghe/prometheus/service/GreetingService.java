package com.hongghe.prometheus.service;

/**
 * @author: hongghe @date: 2019-01-21 16:55
 */
public interface GreetingService {

    String hello(String greeting);

    String response(String key);

    String confirm(String key);
}
