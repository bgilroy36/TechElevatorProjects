package com.techelevator;

public class VendingMachine {

    private int moneyFed;
    private int moneyInMachine;
    private int change;
    private int calculateChange; //Do we need this?

    public VendingMachine(int moneyFed, int moneyInMachine, int change, int calculateChange) {
        this.moneyFed = moneyFed;
        this.moneyInMachine = moneyInMachine;
        this.change = change;
        this.calculateChange = calculateChange;

    }

        public int getMoneyFed(){
            return moneyFed;
        }

        public int getMoneyInMachine(){
        return moneyInMachine;

    }

    public int getChange(){
        return change;
    }

    public int getCalculateChange(){
        return change;
    }
}

