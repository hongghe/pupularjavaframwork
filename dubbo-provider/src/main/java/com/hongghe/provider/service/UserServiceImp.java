package com.hongghe.provider.service;

import com.hongghe.provider.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author: hongghe @date: 2019-03-18 16:33
 */
@Service
public class UserServiceImp implements UserService {
    @Override
    public User saveUser(User user) {
        user.setId(1);
        System.out.println(user.toString());
        return user;
    }
}
