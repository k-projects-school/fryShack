package fryShack.shop;

import java.util.Arrays;

import fryShack.interfaces.Stockable;

public class Stock {
	private Stockable[] inventory = new Stockable[0];

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
