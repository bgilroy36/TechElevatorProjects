package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.RegisterUserDTO;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@PreAuthorize("isAuthenticated()")

public class TransferController {

    private TransferDao transferDao;
    private UserDao userDao;
    private AccountDao accountDao;

//this is how we inject the transferDao(dependency injection)
    public TransferController(TransferDao transferDao, UserDao userDao, AccountDao accountDao) {
        this.transferDao = transferDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
    }




    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public void transferRecord(/*@Valid*/ @RequestBody TransferDTO newTransfer, Principal principal) {
        if (!transferDao.createTransferRecord(1, 1, userDao.findAccountIdbyUsername(principal.getName()), newTransfer.getToAcctId(), newTransfer.getTransferAmt())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "transfer record not created.");
        }
    }

        @RequestMapping(value = "/transferlist", method = RequestMethod.GET)
        public List<Transfer> transfers (Principal principal) {
            return transferDao.userTransferList(userDao.findAccountIdbyUsername(principal.getName()));
        }

    }








