package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByUsername(String username);

    int findIdByUsername(String username);

    //this is boolean for it to work with the controller statement
    boolean create(String username, String password);

    int findAccountIdbyUsername(String username);

    List<User> findUsernames(String username);
}
