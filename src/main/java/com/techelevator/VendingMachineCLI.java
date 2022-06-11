package com.techelevator;

import com.techelevator.view.Menu;

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
	private Purchase purchase;

	public VendingMachineCLI(Menu menu, VendingMachine vendingMachine, Purchase purchase) {
		this.menu = menu;
		this.vendingMachine = vendingMachine;
		this.purchase = purchase;
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
		VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine, purchase);
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
				String choice2 = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
				if (choice2.toUpperCase() == "R");
				{break;}

				if (choice2.equals(SUB_MENU_FEED_MONEY)) {
					while (true) {
						try {
							System.out.println("Feed Money into machine or (R)eturn to previous menu >>>");
							String scan = userInput.nextLine();
							if (scan.toUpperCase().equals("R")) {
								break;
							} else {
								String amountEntered = (scan);
								vendingMachine.feedMoney(Integer.parseInt(amountEntered));

								System.out.println("Current Balance $" + vendingMachine.getMoneyInMachine() + ".00");
							}
						} catch (NumberFormatException ex) {
							System.out.println("Please enter a valid form of currency");
						}
					}

				} if (choice2.equals(MAIN_MENU_OPTION_EXIT)) {
					System.exit(1);

					if (choice2.equals(SUB_MENU_SELECT_PRODUCT)){
						while (true) {
							try {
								System.out.println("Please select the product you want using the slot location >>>");
								String selection = userInput.nextLine();
								//select product method where we get key and stuff
							}
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
}


//	VendingMachine vendingMachine = new VendingMachine();
//	File file = vendingMachine.getInventory().vendMachineCSV;
//	Map<String, Product> inventoryMap = vendingMachine.getInventory(file);


	}