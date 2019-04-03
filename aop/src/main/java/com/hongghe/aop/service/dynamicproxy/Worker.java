package com.hongghe.aop.service.dynamicproxy;

/**
 * @author: hongghe @date: 2019-04-03 16:19
 */
public class Worker implements User {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void find() {
        System.out.println("check");
    }
}
