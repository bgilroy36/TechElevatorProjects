package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private double moneyFed;



    private double moneyInMachine;
    private double change;
    private double cost;
    private String itemName;

    public final int QUARTER = 25;
    public final int DIME = 10;
    public final int NICKEL = 5;

    public int quarterBack = 0;
    public int dimeBack = 0;
    public int nickelBack = 0;


    Inventory inventory = new Inventory();
    //  VendingMachineCLI vmCLI = new VendingMachineCLI();
    List<Product> shoppingCart = new ArrayList<Product>();



    List<String> transactionList = new ArrayList<String>();

    public List<String> getTransactionList() {
        return transactionList;
    }
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

    public double getCost() {
        return cost;
    }

    public Map<String, Product> getInventoryMap() {
        return inventory.getInventoryMap();
    }

    public void setMoneyInMachine(int moneyInMachine) {
        this.moneyInMachine = moneyInMachine;
    }
    public void setMoneyFed() {
        this.moneyFed = moneyFed;
    }

    public void loadInventory() {
        inventory.loadInventory();
    }


    public double makeChange(double moneyInMachine, double cost) {
        change = moneyInMachine - cost;
        if (change <= 0) {
            return 0;
        } else {

            int balance = (int) (change * 100);

            quarterBack = balance / QUARTER;
            balance = balance % QUARTER;
            change =

            dimeBack = balance / DIME;
            balance = balance % DIME;

            nickelBack = balance / NICKEL;
            balance = balance % NICKEL;

            System.out.println(String.format("Dispensing change, %d quarters, %d dimes, %d nickels", quarterBack, dimeBack, nickelBack));
        }

        return change;
    }

    public int getNewBalance() {
        return newBalance;
    }

    private int newBalance = 0;
    private int availableBalance;
    Scanner userInput = new Scanner(System.in);



    public void feedMoney( double moneyInserted) {
        if (moneyInserted >= 1) {
            this.moneyInMachine = (int) (getMoneyInMachine() + moneyInserted);


        }
    }


    public String selectProduct(String slotKey) {
        if (getInventoryMap().containsKey(slotKey)) {
            Product selectedItem = getInventoryMap().get(slotKey);
            itemName = selectedItem.getName();
            String itemType = selectedItem.getType();
            String yum = null;





            if (selectedItem.getCounter() > 0 && moneyInMachine >= cost) {
                //check if there's enough money, if yes subtract from counter and subtract money from moneyInMachine
                //missing something here to subtract item selected from available quantity
                shoppingCart.add(getInventoryMap().get(slotKey));
                cost = selectedItem.getPrice();
                moneyInMachine -= cost;
                int updatedQty = selectedItem.getCounter();
                 yum = selectedItem.getItemSound();
               //******how do I call reduce cost here?*****
                //} else if (!selecteditem.inventory.getavailablequantity()) { sout "SOLD OUT!") break;
                // else { sout ("insufficient balance, please insert U.S Dollars") break
                //NEED TO PUT THIS FUNCTION IN VENDING MACHINE CLI
            } else {
                return "Sold Out";
            }
            return itemName + "\n" + yum; //crunch crunch etc
        }
        return "Invalid item key " + slotKey;
    }
    public void logTransactions() throws IOException {
        File outputFile = new File("Log.txt");
        List<String> list = getTransactionList();
        try (FileWriter logWriter = new FileWriter(outputFile,true)) {
            for (String logLine : transactionList) {
                logWriter.write(logLine);
                logWriter.write("\n");
            }
        }
    }
    public List<String> log(String eventMessage, double moneyBeforeTransaction, double moneyAfterTransaction) throws IOException {
        LocalDateTime time = LocalDateTime.now();
        String logLine = String.format("%s %-20.20s $%.2f $%.2f", time, eventMessage, moneyBeforeTransaction, moneyAfterTransaction);
        transactionList.add(logLine);
        logTransactions();
        transactionList.clear();
        return transactionList;
    }


}












