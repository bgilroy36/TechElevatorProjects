package com.techelevator;

import java.util.Scanner;

public class VendingMachine {

    private double moneyFed;
    private double moneyInMachine;
    private double change;
    private double cost;

    public final int QUARTER = 25;
    public final int DIME = 10;
    public final int NICKEL = 5;

    public static int quarterBack = 0;
    public static int dimeBack = 0;
    public static int nickelBack = 0;

Inventory inventory = new Inventory();
public void snackItem = inventory.loadInventory();

    public Inventory getInventory() {
        return inventory;
    }



Scanner userInput = new Scanner(System.in);

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

        public double getChange () {
            return change;
        }

        public double makeChange ( double moneyFed, double cost){
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

    }





