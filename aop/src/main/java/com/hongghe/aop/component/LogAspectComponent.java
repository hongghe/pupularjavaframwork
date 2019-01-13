package com.hongghe.aop.component;

import com.hongghe.aop.annotation.LogFormatAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: hongghe @date: 2019-01-13 14:39
 */
@Slf4j
@Aspect
@Component
public class LogAspectComponent {

    @Pointcut("@annotation(com.hongghe.aop.annotation.LogFormatAnnotation)")
    private void cut() {}

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
       MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        LogFormatAnnotation annotation = method.getAnnotation(LogFormatAnnotation.class);
        System.out.print("打印：" + annotation.value() + " 前置日志");
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
