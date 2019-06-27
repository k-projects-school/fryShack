package fryShack.foods;

import fryShack.enums.Meat;
import fryShack.interfaces.Fryable;
import fryShack.interfaces.Orderable;
import fryShack.interfaces.Stockable;

public class Snack implements Fryable, Orderable, Stockable{
	private String name;
	private double price;
	
	public Snack(Meat snack) {
		this.name = snack.getName();
		this.price = snack.getPrice();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}
