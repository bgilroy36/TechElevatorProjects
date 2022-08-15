package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
import java.security.Principal;

public interface AccountDao {

    BigDecimal getBalance(String username);

    BigDecimal addTransferAmt(BigDecimal transferAmt, int toUserId);


    void transfer(int fromAccountId, int toAccountId, BigDecimal fromNewBalance, BigDecimal toNewBalance);

    BigDecimal subTransferAmt(BigDecimal transferAmt, int fromUserId);

    BigDecimal getBalanceByAccountId(int acctId);



}
