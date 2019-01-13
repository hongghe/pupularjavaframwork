package com.hongghe.aop.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-13 14:42
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogFormatAnnotation {
    String value() default "log format";
    String logg();
}
