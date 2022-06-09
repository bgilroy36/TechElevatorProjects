package com.techelevator;

public class VendingMachine {

    private double moneyFed;
    private double moneyInMachine;
    private double change;
    private double cost;

    public VendingMachine(double moneyFed, double moneyInMachine, double change, double cost) {
        this.moneyFed = moneyFed;
        this.moneyInMachine = moneyInMachine;
        this.change = change;
        this.cost = cost;


    }

    public double getMoneyFed() {
        return moneyFed;
    }

    public double getMoneyInMachine() {
        return moneyInMachine;

    }

    public double getChange() {
        return change;
    }

    public double makeChange(double moneyFed,double cost) {
        change = moneyFed - cost;
        return change;
    }


}

