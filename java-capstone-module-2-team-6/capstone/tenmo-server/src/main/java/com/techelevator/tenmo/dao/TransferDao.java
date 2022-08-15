package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {





    List<Transfer> userTransferList (int userId);


    Transfer findByTransferId (int transferId);

    boolean transfer();

    boolean createTransferRecord(int transferTypeId, int tranStatusId, int fromAcctId, int toAcctId, BigDecimal amount);






}
