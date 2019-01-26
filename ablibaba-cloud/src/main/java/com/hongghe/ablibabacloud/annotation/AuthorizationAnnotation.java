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
     * @return 注释的结果信息
     */
    String value() default "注解";
}
