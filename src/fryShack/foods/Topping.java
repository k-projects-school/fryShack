package fryShack.foods;

import fryShack.enums.ToppingType;
import fryShack.interfaces.Orderable;
import fryShack.interfaces.Stockable;

public class Topping implements Orderable, Stockable {
	private String name = "";
	private double price = 0.5;

	/**
	 * Constructor
	 * 
	 * @param toppingTypes - The types of toppings
	 */
	public Topping(ToppingType... toppingTypes) {
		init(toppingTypes);
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Get the price
	 * 
	 * @return The price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Initialize the topping
	 * 
	 * @param toppingTypes - The types of toppings
	 */
	private void init(ToppingType... toppingTypes) {
		int toppingCount = 0;
		for (ToppingType type : toppingTypes) {
			this.name += type.getName() + ", ";
			toppingCount++;
		}

		this.price *= Math.ceil(toppingCount / 4);

		this.name = this.name.substring(0, this.name.length() - 1);
	}
}
