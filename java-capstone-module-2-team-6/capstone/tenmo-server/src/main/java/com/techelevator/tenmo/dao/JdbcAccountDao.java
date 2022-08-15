package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{


private JdbcTemplate jdbcTemplate;
private UserDao userDao;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
    }

    @Override
    public BigDecimal getBalance(String username) {
        String sql = "SELECT balance FROM account where account_id = ?";
        int accountId = userDao.findAccountIdbyUsername(username);

        BigDecimal balance = jdbcTemplate.queryForObject(sql,BigDecimal.class,accountId);

        return balance;
    }

    @Override
    public BigDecimal getBalanceByAccountId(int acctId) {
        String sql = "SELECT balance FROM account where account_id = ?";

        BigDecimal balance = jdbcTemplate.queryForObject(sql,BigDecimal.class, acctId);

        return balance;
    }

    @Override
    public BigDecimal addTransferAmt(BigDecimal transferAmt, int toUserId) {
        return null;
    }

    //
    @Override
    public void transfer(int fromAccountId, int toAccountId, BigDecimal fromNewBalance, BigDecimal toNewBalance) {
        String sql = "UPDATE account set balance = ?" +
                " WHERE account_id = ?";
        String sql2 = "UPDATE account set balance = ?" +
                " WHERE account_id = ?";

         jdbcTemplate.update(sql, fromNewBalance, fromAccountId);
         jdbcTemplate.update(sql2, toNewBalance, toAccountId);
    }
//
//
//        String sql = "UPDATE" <---- can do both addition and subtraction in one method, 2 sequal statements, wrap in transaction
    // TODO need to add "transaction" points.
    //  Both addition and subtraction points are working.
    //   Had to add "LIMIT 1" to each statement for it to query properly.
    //   Checkout transfer controller to see how the api side works
    //      Also it is working but maybe we can optimize if we have time
    //      We can easily split out the statements if ya like.

//    }

    @Override
    public BigDecimal subTransferAmt(BigDecimal transferAmt, int fromUserId) {
        return null;
    }


}
