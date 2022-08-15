package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int transferTypeId;
    private String transferTypeDesc;
    private int fromUserId;
    private int toUserId;
    private BigDecimal transferAmount;
    private int transferId;
    private int transferStatusId;
    private String transferStatusDesc;

    public Transfer(){

    }

    public Transfer (int transferTypeId, int fromUserId, int toUserId,
                     BigDecimal transferAmount, int transferId, int transferStatusId){
        this.transferTypeId = transferTypeId;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.transferAmount = transferAmount;
        this.transferId = transferId;
        this.transferStatusId = transferStatusId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public String getTransferTypeDesc() {
        return transferTypeDesc;
    }

    public void setTransferTypeDesc(String transferTypeDesc) {
        this.transferTypeDesc = transferTypeDesc;
    }

    public int getFromAcctId() {
        return fromUserId;
    }

    public void setFromAcctId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToAcctId() {
        return toUserId;
    }

    public void setToAcctId(int toUserId) {
        this.toUserId = toUserId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public String getTransferStatusDesc() {
        return transferStatusDesc;
    }

    public void setTransferStatusDesc(String transferStatusDesc) {
        this.transferStatusDesc = transferStatusDesc;
    }
}
