package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class AccountDTO {

    private int accountNum;
    private BigDecimal balance;

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

//    public String toString() {
//        return "LoginDTO{" +
//                "accountNum" + accountNum;
//}
