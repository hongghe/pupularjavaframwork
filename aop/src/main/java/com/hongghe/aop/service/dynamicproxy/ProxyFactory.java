package com.hongghe.aop.service.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: hongghe @date: 2019-04-03 16:31
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * <p>动态代理实例</p>
     *
     * @return 代理的对象
     */
    public Object getProxyInstance() {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        Object result = null;
                        if ("find".equalsIgnoreCase(methodName)) {
                            result = method.invoke(target, args);
                        } else {
                            System.out.println("begin ...");
                            result = method.invoke(target, args);
                            System.out.println("end ...");
                        }
                        return result;
                    }
                });
        return proxy;
    }

    public static void main(String[] args) {
        User target = new Worker();
        System.out.println("target object:" + target.getClass());
        User proxy = (User) new ProxyFactory(target).getProxyInstance();
        System.out.println("proxy object: " + proxy.getClass());
        proxy.save();
        proxy.find();
    }
}
