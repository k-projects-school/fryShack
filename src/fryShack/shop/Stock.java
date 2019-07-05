package fryShack.shop;

import java.util.Arrays;

import fryShack.app.HandleInput;
import fryShack.drinks.Alcohollic;
import fryShack.drinks.SoftDrink;
import fryShack.enums.AlcoholType;
import fryShack.enums.Meat;
import fryShack.enums.SauceFlavor;
import fryShack.enums.SauceSize;
import fryShack.enums.SodaFlavor;
import fryShack.enums.ToppingType;
import fryShack.foods.Sauce;
import fryShack.foods.Snack;
import fryShack.foods.Topping;
import fryShack.interfaces.Stockable;

public class Stock {
	private Stockable[] inventory = new Stockable[0];

	/**
	 * Initialize the inventory of the stock
	 * 
	 * @param stockables
	 */
	public void initStock() {
		System.out.println("What would you like to do?");
		System.out.println("[1] Set the same amount for every product");
		System.out.println("[2] Set the amount per product");

		int choice = HandleInput.processInitStockStep1();

		switch (choice) {
		case 1:
			System.out.println("How many of each product do you want to store in the stock?");
			int response = HandleInput.getPositiveInt();
			Stockable[] tempInventory = new Stockable[0];
			for (AlcoholType alcoholType : AlcoholType.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new Alcohollic(alcoholType);
				}
			}

			for (Meat meat : Meat.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new Snack(meat);
				}
			}

			for (SauceFlavor sauceFlavor : SauceFlavor.values()) {
				for (SauceSize sauceSize : SauceSize.values()) {
					for (int i = 0; i < response; i++) {
						tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
						tempInventory[tempInventory.length - 1] = new Sauce(sauceFlavor, sauceSize);
					}
				}
			}

			for (SodaFlavor sodaFlavor : SodaFlavor.values()) {
				for (int i = 0; i < response; i++) {
					tempInventory = Arrays.copyOf(tempInventory, tempInventory.length + 1);
					tempInventory[tempInventory.length - 1] = new SoftDrink(sodaFlavor);
				}
			}
			this.initStock(tempInventory);
			System.out.println(this.inventory.length);
			break;
		case 2:
			break;
		}
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
