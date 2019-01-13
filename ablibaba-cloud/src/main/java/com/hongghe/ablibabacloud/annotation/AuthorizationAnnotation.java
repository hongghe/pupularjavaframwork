package com.hongghe.ablibabacloud.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-13 14:19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthorizationAnnotation {

    /**
     * 注解定义
     * @return
     */
    String value() default "注解";
}
