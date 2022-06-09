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

    public void loadInventory() {
        try (Scanner invList = new Scanner(vendMachineCSV);) {
            while (invList.hasNextLine()) {
                String invString = invList.nextLine();
               String [] itemArray = invString.split("\\|");
               Product product = new Product(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]);
               inventoryMap.put(itemArray[0], product);

            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
