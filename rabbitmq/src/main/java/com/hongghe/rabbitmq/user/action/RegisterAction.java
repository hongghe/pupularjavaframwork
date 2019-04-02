package com.hongghe.rabbitmq.user.action;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: hongghe @date: 2019-03-26 15:35
 */
@Component
public class RegisterAction <K, V> implements Serializable {

    private static final long serialVersionUID = -1121626513450877325L;

    public <K> K getActionName(V v) {
        if (v.equals("name")) {
            return (K)v;
        }
        return null;
    }
}
