package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    private static final int MAXIMUM_AMOUNT = 5;
    private boolean isSoldOut;
    private Map<String, Product> inventoryMap = new TreeMap<>();
    File vendMachineCSV = new File("vendingmachine.csv");

    public int getMaximumAmount() {
        return MAXIMUM_AMOUNT;
    }

    public boolean getIsSoldOut() {
        return isSoldOut;
    }

    public Map<String, Product> getInventoryMap() {
        return inventoryMap;
    }

    public void stockInventory() {
        try (Scanner invList = new Scanner(vendMachineCSV);) {
            while (invList.hasNextLine()) {
                
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
