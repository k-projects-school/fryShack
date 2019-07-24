package fryShack.shop;

import java.util.Arrays;

import fryShack.app.HandleInput;
import fryShack.drinks.*;
import fryShack.enums.*;
import fryShack.foods.Sauce;
import fryShack.foods.Snack;
import fryShack.interfaces.Stockable;

public class Stock {
	private Stockable[] inventory = new Stockable[0];

	/**
	 * Initialize the inventory of the stock
	 * 
	 * @param stockables
	 */
	public void init() {
		this.printMenu();

		int choice = HandleInput.processInitStockStep1();

		switch (choice) {
		case 1:
			System.out.println("How many of each product do you want to store in the stock?");
			int response = HandleInput.getPositiveInt();
			Stockable[] tempInventory = new Stockable[0];
			System.out.println("Processing Alcoholics...");
			for (AlcoholType alcoholType : AlcoholType.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new Alcohollic(alcoholType);
				}
			}

			System.out.println("Processing Meat...");
			for (Meat meat : Meat.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new Snack(meat);
				}
			}

			System.out.println("Processing Sauce...");
			for (SauceFlavor sauceFlavor : SauceFlavor.values()) {
				for (SauceSize sauceSize : SauceSize.values()) {
					for (int i = 0; i < response; i++) {
						tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
						tempInventory[tempInventory.length - 1] = new Sauce(sauceFlavor, sauceSize);
					}
				}
			}

			System.out.println("Processing Soda...");
			for (SodaFlavor sodaFlavor : SodaFlavor.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new SoftDrink(sodaFlavor);
				}
			}
			System.out.println("Finishing...");
			this.initStock(tempInventory);
			System.out.println("Done!");
			break;
		case 2:
			break;
		}
	}

	/**
	 * Print the stock menu
	 */
	private void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("[1] Set the same amount for every product");
		System.out.println("[2] Set the amount per product");
	}

	/**
	 * Initialize the inventory of the stock
	 * 
	 * @param stockables
	 */
	public void initStock(Stockable... stockables) {
		this.inventory = stockables;
	}

	/**
	 * Add an item to the inventory
	 * 
	 * @param stockable
	 */
	public void addItem(Stockable stockable) {
		this.inventory = Arrays.copyOf(this.inventory, this.inventory.length + 1);
		this.inventory[this.inventory.length - 1] = stockable;
	}

	/**
	 * Add multiple items to the inventory
	 * 
	 * @param stockables
	 */
	public void addItems(Stockable... stockables) {
		for (Stockable stockable : stockables) {
			this.addItem(stockable);
		}
	}

	/**
	 * Remove an item from the stock
	 * 
	 * @param stockable
	 */
	public void removeItem(Stockable stockable) {
		Stockable[] temp = Arrays.copyOf(this.inventory, this.inventory.length - 1);
		int index = 0;
		for (Stockable _stockable : this.inventory) {
			if (!_stockable.equals(stockable)) {
				temp[index++] = _stockable;
			}
		}

		this.inventory = temp;
	}

	/**
	 * Remove multiple items from the stock
	 * 
	 * @param stockables
	 */
	public void removeItems(Stockable... stockables) {
		for (Stockable stockable : stockables) {
			this.removeItem(stockable);
		}
	}
}
