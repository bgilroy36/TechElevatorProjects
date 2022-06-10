package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {

    private double moneyFed;
    private double moneyInMachine;
    private double change;
    private double cost;

    public final int QUARTER = 25;
    public final int DIME = 10;
    public final int NICKEL = 5;

    public int quarterBack = 0;
    public int dimeBack = 0;
    public int nickelBack = 0;


    Scanner userInput = new Scanner(System.in);
    Inventory inventory = new Inventory();


    public VendingMachine() {

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

    public Inventory getInventory() {
        return inventory;
    }

    public Map<String, Product> getInventoryMap() {
        return inventory.getInventoryMap();
    }


    public void setMoneyFed() {
        this.moneyFed = moneyFed;
    }

    public void loadInventory() {
       inventory.loadInventory();
    }



    public double makeChange(double moneyFed, double cost) {
        double dueBack = moneyFed - cost;
        if (dueBack <= 0) {
            return 0;
        } else {

            int balance = (int) (dueBack * 100);

            quarterBack = balance / QUARTER;
            balance = balance % QUARTER;

            dimeBack = balance / DIME;
            balance = balance % DIME;

            nickelBack = balance / NICKEL;
            balance = balance % NICKEL;

            System.out.println(String.format("Dispensing change, %d quarters, %d dimes, %d nickels", quarterBack, dimeBack, nickelBack));
        }

        return dueBack;
    }

    public void feedMoney() {
        System.out.println("");
       // int moneyInserted =
    }


}



