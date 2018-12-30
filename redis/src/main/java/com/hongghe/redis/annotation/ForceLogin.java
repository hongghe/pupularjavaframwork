package com.hongghe.redis.annotation;

import java.lang.annotation.*;

/**
 * @author hongghe 2018/12/28
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForceLogin {

    boolean login() default true;

}