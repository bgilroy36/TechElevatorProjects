package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private double moneyFed;
    private int moneyInMachine;
    private double change;
    private double cost;

    public final int QUARTER = 25;
    public final int DIME = 10;
    public final int NICKEL = 5;

    public int quarterBack = 0;
    public int dimeBack = 0;
    public int nickelBack = 0;
    Product selectedItem;





    Inventory inventory = new Inventory;
    VendingMachineCLI vmCLI = new VendingMachineCLI;


    public VendingMachine() {

    }

    public double getMoneyFed() {
        return moneyFed;
    }

    public int getMoneyInMachine() {
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
    public int getNewBalance() {
        return newBalance;
    }

    private int newBalance = 0;
    private int availableBalance;
    Scanner userInput = new Scanner(System.in);



    public void feedMoney(int moneyInserted) {
        if (moneyInserted >= 1) {
            this.moneyInMachine = (int) (getMoneyInMachine() + moneyInserted);
            System.out.println("Thank you for inserting money: $" + moneyInserted + ".00");

        }
         }


public void selectProduct() {
      if (getInventoryMap().containsKey(vmCLI.getSelection())) {
         selectedItem = getInventoryMap().get(vmCLI.getSelection());
          //if (vmCLI.getSelection());
      }

        if (inventory.hasQty() && moneyInMachine >= selectedItem.getPrice()) {
            int subtractQty = inventory.getAvailableQuantity() -1;
        }
        }


    }












