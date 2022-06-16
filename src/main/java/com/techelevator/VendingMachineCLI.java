package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private static final String SUB_MENU_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
    private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION};

    Scanner userInput = new Scanner(System.in);

    private String selection;

    private Menu menu;
    private VendingMachine vendingMachine;

    public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;

    }

    public VendingMachineCLI() {

    }

    public Map<String, Product> getInventoryMap() {
        return getInventoryMap();
    }

    public Scanner getUserInput() {
        return userInput;
    }

    public String getSelection() {
        return selection;
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachine vendingMachine = new VendingMachine();
        Purchase purchase = new Purchase();
        vendingMachine.loadInventory();
        VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine);
        cli.run();
    }


    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                //display items here
                Map<String, Product> displayItems = vendingMachine.getInventoryMap();
                for (Map.Entry<String, Product> itemEntry : displayItems.entrySet()) {
                    Product product = itemEntry.getValue();
                    System.out.printf("%s %-20.20s %.2f %s%n", itemEntry.getKey(), product.getName(), product.getPrice(), product.getType());
                }
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                boolean subRun = true;
                while (subRun) {
                    // do purchase
                    String choice2 = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
                    System.out.printf("Current Balance $%.2f %n", vendingMachine.getMoneyInMachine());
//                if (choice2.toUpperCase() == "R") ;
//                {
//
//                }

                    if (SUB_MENU_FEED_MONEY.equals(choice2)) {

                        try {
                            System.out.println("Feed Money into machine or (R)eturn to previous menu >>>");
                            String scan = userInput.nextLine();
                            if (scan.toUpperCase().equals("R")) {
                                break;
                            } else {
                                String amountEntered = (scan);
                                double moneyInserted = Double.parseDouble(amountEntered);
                                vendingMachine.feedMoney(moneyInserted);
                                logMessage("Feed Money" , vendingMachine.getMoneyInMachine());
                                System.out.printf("Thank you for inserting money: $%.2f %n", moneyInserted);

                                System.out.printf("Current Balance $%.2f %n", vendingMachine.getMoneyInMachine());
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Please enter a valid form of currency");
                        }
                    } else if (choice2.equals(SUB_MENU_SELECT_PRODUCT)) {
//select product method
                        try {
                            System.out.println("Please select the product you want using the slot location >>>");
                            String selection = userInput.nextLine();
                            selection = selection.toUpperCase();
                            String selectionResponse = vendingMachine.selectProduct(selection);
                            System.out.println("You have chosen " + selectionResponse );
                            Product product = vendingMachine.getInventoryMap().get(selection);
                            logMessage(product.getName() + " " + selection, product.getPrice());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } //submen will end after transaction
                    else if (choice2.equals(SUB_MENU_FINISH_TRANSACTION)) {
                        subRun = false;
                        double dueBack = vendingMachine.getChange();
                        System.out.println(" Your change is: " + vendingMachine.makeChange(dueBack, vendingMachine.getCost()));
                        vendingMachine.setMoneyInMachine(0);
                        System.out.println("Your balance is now " + vendingMachine.getMoneyInMachine());
                        //return change, ask the vending machine for the change and print it out

                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(1);
            }
        }
    }

    private void logMessage(String logMessage, double firstCost) {
        try {
            vendingMachine.log(logMessage, firstCost, vendingMachine.getMoneyInMachine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//	public void displayItems() {
//		System.out.println("Options include: " + vendingMachine.getInventory() );
//		for (String snack : ());
//		System.out.println();
    //create an instance of a vending machine with a member variable of Inventory


//	public String displayItems() {
//		String result = "";
//		for (String key : getInventoryMap().keySet()) {
//			Product display = getInventoryMap().get(key);
//			String formattedName = String.format("%-20s", display.getProduct().getName());
//			result += display.getSlot() + " " + formattedName + " " + display.getProduct().getPrice() + "  Qty: "
//					+ display.getQuantity() + "\n";

//		}
}






