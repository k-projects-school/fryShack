package fryShack.foods;

import fryShack.enums.Size;
import fryShack.interfaces.Fryable;
import fryShack.interfaces.Orderable;
import fryShack.interfaces.Stockable;

public class Fries implements Fryable, Orderable, Stockable{
	private double price;
	private String name;
	
	public Fries(Size friesSize) {
		this.price = friesSize.getPrice();
		this.name = friesSize.getName();
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
