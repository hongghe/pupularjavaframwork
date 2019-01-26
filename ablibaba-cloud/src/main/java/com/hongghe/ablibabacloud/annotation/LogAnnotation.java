package com.hongghe.ablibabacloud.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-13 15:49
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {

    /**
     * Content of log.
     */
    String value() default "log";

    /**
     * The log action of user.
     */
    String log();
}
