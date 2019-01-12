package com.hongghe.jpa.dao;

import com.hongghe.jpa.JpaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: hongghe @date: 2019-01-12 10:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
//指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = JpaApplication.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
@WebAppConfiguration
public class AnimalDAOTest {

    @Autowired
    private AnimalDAO animalDAO;

    @Test
    public void test1(){
        animalDAO.findByUserName(1L);
    }
}