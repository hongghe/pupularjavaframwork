package com.hongghe.dubboconsumer.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-12 15:33
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginAnnotation {
    boolean login() default true;
}
