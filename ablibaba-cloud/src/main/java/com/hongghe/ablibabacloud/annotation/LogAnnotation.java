package com.hongghe.ablibabacloud.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-13 15:49
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String value() default "日志";
    String log();
}
