package com.hongghe.aop.annotation;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-15 18:41
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExceptionAnnotation {
}
