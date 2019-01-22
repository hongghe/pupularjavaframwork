package com.hongghe.aop.component;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: hongghe @date: 2019-01-22 10:13
 */
public class LogPointCuts {

    /**
     * The controller point cut of service
     */
    @Pointcut("execution(public * com.hongghe.aop.controller.*.*(..))")
    public void pointCutController(){}

    /**
     * The service point cut of service
     */
    @Pointcut("execution(public * com.hongghe.aop.service.*.*(..))")
    public void pointCutService(){}
}
