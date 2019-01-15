package com.hongghe.aop.annotation;

import com.hongghe.aop.domain.UserApplyStatus;

import java.lang.annotation.*;

/**
 * @author: hongghe @date: 2019-01-15 18:29
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplyAnnotation {
    UserApplyStatus userApplyStatus() default UserApplyStatus.NOT;
}
