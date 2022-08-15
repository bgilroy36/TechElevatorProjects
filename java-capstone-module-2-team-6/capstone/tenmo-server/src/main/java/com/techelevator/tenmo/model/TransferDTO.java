package com.techelevator.tenmo.model;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class TransferDTO {


    @NotEmpty
    private int transferTypeId;

    @NotEmpty
    private int transferStatusId;

    @NotEmpty
    private int fromAcctId;

    @NotEmpty
    private int toAcctId;

    @NotEmpty
    private BigDecimal transferAmt;


    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public int getFromAcctId() {
        return fromAcctId;
    }

    public void setFromAcctId(int fromAcctId) {
        this.fromAcctId = fromAcctId;
    }

    public int getToAcctId() {
        return toAcctId;
    }

    public void setToAcctId(int toAcctId) {
        this.toAcctId = toAcctId;
    }

    public BigDecimal getTransferAmt() {
        return transferAmt;
    }

    public void setTransferAmt(BigDecimal transferAmt) {
        this.transferAmt = transferAmt;
    }
}
