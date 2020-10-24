package com.hongghe.aop.demo;

import com.hongghe.aop.domain.Result;
import com.hongghe.aop.message.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author honghe zhang
 * @date 2020/10/24
 */
public class DemoAop {

    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        System.out.println("context 启动成功");
        User user = context.getBean(User.class);
        System.out.println(user.toString());
    }
}
