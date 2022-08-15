package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
    }

    @Override
    public boolean transfer() {

        return false;
    }

    @Override
    public boolean createTransferRecord(int transferTypeId, int tranStatusId, int fromAcctId, int toAcctId, BigDecimal amount) {
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES (?, ?, ?, ?, ?)" +
                "RETURNING transfer_id";
        try {
            Integer newTransferId = jdbcTemplate.queryForObject(sql, Integer.class, transferTypeId, tranStatusId, fromAcctId, toAcctId, amount);

           BigDecimal fromNewBalance = accountDao.getBalanceByAccountId(fromAcctId);
           BigDecimal toNewBalance = accountDao.getBalanceByAccountId(toAcctId);
          fromNewBalance = fromNewBalance.subtract(amount);
          toNewBalance = toNewBalance.add(amount);
            accountDao.transfer(fromAcctId, toAcctId, fromNewBalance, toNewBalance);

            // TODO use the get account and get balance to finish this. Simplify the SQL statement because we will have userId and can use that to get accountId
            //  NOBLE note: simplified statement. Now works in postman.
            //   See TransferController on how each value is being passed.

        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public Transfer findByTransferId(int transferId) {
        return null;
    }

    @Override
    public List<Transfer> userTransferList(int acctId) {
String sql = "SELECT account_to,account_from, amount FROM transfer WHERE account_from = ? OR account_to = ?;";
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, acctId, acctId);
        while (results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }

    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferTypeId(rs.getInt("transfer_type_id"));
        transfer.setFromAcctId(rs.getInt("account_from"));
        transfer.setToAcctId(rs.getInt("account_to"));
        transfer.setTransferAmount(rs.getBigDecimal("amount"));
        return transfer;
    }

    private Transfer mapRowToUserTrn(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferTypeId(rs.getInt("transfer_type_id"));
        transfer.setFromAcctId(rs.getInt("account_from"));
        transfer.setToAcctId(rs.getInt("account_to"));
        transfer.setTransferAmount(rs.getBigDecimal("amount"));
        return transfer;
    }
}
