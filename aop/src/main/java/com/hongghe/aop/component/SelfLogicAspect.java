package com.hongghe.aop.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: hongghe @date: 2019-01-22 10:16
 */
@Aspect
@Slf4j
public class SelfLogicAspect{

    @Before("LogPointCuts.pointCutController()")
    public void doSthBefore(JoinPoint joinpoint){
        //自定义逻辑
        log.info("before method.");
    }

    //restController2()虽不是static方法，但可以用“类.name()“形式调用
    @Around("LogPointCuts.pointCutService()")
    public void doSthAround(ProceedingJoinPoint joinpoint) { //@Around时，参数是ProceedingJoinPoint 类型
        //自定义逻辑
        log.info("before method.");
        boolean flag = true;
        if(flag) {
            //验证通过，让程序继续执行下去
            try {
                joinpoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            //做其他处理，一般中断程序执行，返回错误信息给client
        }
    }

}