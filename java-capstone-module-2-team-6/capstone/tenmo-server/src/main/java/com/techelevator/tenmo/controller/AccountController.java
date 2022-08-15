package com.techelevator.tenmo.controller;



import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
public class AccountController {


    private AccountDao accountDao;
    private UserDao userDao;

    public AccountController(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public int accountId(Principal principal) {
        return userDao.findAccountIdbyUsername(principal.getName());
    }


    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public BigDecimal balance(Principal principal) {
        String username = principal.getName();
        return accountDao.getBalance(username);
    }


}
