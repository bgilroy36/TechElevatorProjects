package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	private VendingMachine vendingMachine;
	public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
		this.menu = menu;
		this.vendingMachine = vendingMachine;
	}

	public Map<String, Product> getInventoryMap() {return getInventoryMap();}

	public static void main (String[]args){
		Menu menu = new Menu(System.in, System.out);
		VendingMachine vendingMachine = new VendingMachine();
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
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(1);
			}

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


//	VendingMachine vendingMachine = new VendingMachine();
//	File file = vendingMachine.getInventory().vendMachineCSV;
//	Map<String, Product> inventoryMap = vendingMachine.getInventory(file);

