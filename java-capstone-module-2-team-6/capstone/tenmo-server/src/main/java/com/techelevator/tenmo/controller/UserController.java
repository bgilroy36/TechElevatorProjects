package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    //Moved this from authenticationController
    //works with the findAllUsers
    @RequestMapping(value = "/recipients", method = RequestMethod.GET)
    public List<User> usernames (Principal principal) {
        return userDao.findUsernames(principal.getName());
    }


    @RequestMapping(value = "/users", method =  RequestMethod.GET)
    public List<User> users() {
            return userDao.findAll();
        }

    }
    //create





