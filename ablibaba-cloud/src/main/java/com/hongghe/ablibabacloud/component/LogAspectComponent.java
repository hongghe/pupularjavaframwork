package com.hongghe.ablibabacloud.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-19 14:56
 */
@Slf4j
@Aspect
@Component
public class LogAspectComponent {

   // 定义一个 Pointcut, 使用 切点表达式函数 来描述对哪些 Join point 使用 advise.
   @Pointcut("@annotation(com.hongghe.ablibabacloud.AuthorizationAnnotation)")
   public void pointcut() {
   }

   // 定义 advise
   @Around("pointcut()")
   public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {
       HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
               .getRequest();

       // 检查用户所传递的 token 是否合法
       String token = getUserToken(request);
       if (!token.equalsIgnoreCase("123456")) {
           return "错误, 权限不合法!";
       }

       return joinPoint.proceed();
}
