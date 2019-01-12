package com.hongghe.jpa.controller;

import com.google.gson.Gson;
import com.hongghe.jpa.dao.AnimalDAO;
import com.hongghe.jpa.dao.UserRepository;
import com.hongghe.jpa.entity.Animal;
import com.hongghe.jpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: hongghe @date: 2019-01-09 16:25
 */
@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserInformationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnimalDAO animalDAO;

    @RequestMapping("{username}")
    public List<User> getUser(@PathVariable("username") String username) {
        List<User> userList = this.userRepository.findByUsernameContaining(username);
        return userList;
    }

    @RequestMapping(value = "animal")
    public List<Animal> getAnimal(@RequestParam Long id) {
        log.error("[animal] start");
        List<Animal> animalId = this.animalDAO.queryFamilyList(id);
        log.error("animal = {}", new Gson().toJson(animalId));
        log.error("[animal] end");
        return animalId;
    }
}
