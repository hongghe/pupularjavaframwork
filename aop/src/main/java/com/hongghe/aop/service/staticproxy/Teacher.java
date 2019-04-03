package com.hongghe.aop.service.staticproxy;

/**
 * @author: hongghe @date: 2019-04-03 16:21
 */public class Teacher implements User {

     private User user = new Worker();

    @Override
    public void save() {
        System.out.println("begin");
        user.save();
        System.out.println("end");
    }

    @Override
    public void find() {
        user.find();
    }


    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.save();
        teacher.find();
    }
}

