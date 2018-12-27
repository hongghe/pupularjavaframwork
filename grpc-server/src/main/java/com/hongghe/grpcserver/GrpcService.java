package com.hongghe.grpcserver;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author hongghe 2018/12/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GrpcService {
}