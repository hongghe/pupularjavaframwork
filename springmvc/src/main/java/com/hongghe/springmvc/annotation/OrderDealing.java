package com.hongghe.springmvc.annotation;

import com.hongghe.springmvc.domain.OrderStatus;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-14 15:39
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderDealing {
    OrderStatus orderStatus() default OrderStatus.APPLYING;
}
