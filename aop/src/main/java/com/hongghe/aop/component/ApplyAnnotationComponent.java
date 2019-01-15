package com.hongghe.aop.component;

import com.hongghe.aop.annotation.ApplyAnnotation;
import com.hongghe.aop.annotation.LogFormatAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: hongghe @date: 2019-01-15 18:43
 */
@Slf4j
@Aspect
@Component
public class ApplyAnnotationComponent {

    @Pointcut("@annotation(com.hongghe.aop.annotation.ApplyAnnotation)")
    private void cut() {}

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        ApplyAnnotation annotation = method.getAnnotation(ApplyAnnotation.class);
    }

    /**
     * 定制一个环绕通知
     * @param joinPoint
     */
    @Around("cut()")
    public void advice(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知之开始");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知之结束");
    }

    // 当想获得注解里面的属性，可以直接注入改注解
    @Before("cut() && @annotation(logFormatAnnotation)")
    public void record(JoinPoint joinPoint, LogFormatAnnotation logFormatAnnotation) {
        System.out.println(logFormatAnnotation.value());
    }

    @After("")
    public void after() {
    }
}
