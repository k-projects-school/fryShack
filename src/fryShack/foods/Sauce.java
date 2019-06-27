package fryShack.foods;

import fryShack.enums.SauceFlavor;
import fryShack.enums.SauceSize;
import fryShack.interfaces.Orderable;
import fryShack.interfaces.Stockable;

public class Sauce implements Orderable, Stockable{
	private String name, size;
	private double price;

	/**
	 * Constructor
	 * 
	 * @param flavor - The flavor of the sauce
	 * @param size   - The size of the sauce
	 */
	public Sauce(SauceFlavor flavor, SauceSize size) {
		this.name = flavor.getName();
		this.calculatePrice(flavor, size);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Calculate the price of the sauce
	 * 
	 * @param flavor - The flavor of the sauce
	 * @param size   - The size of the sauce
	 */
	private void calculatePrice(SauceFlavor flavor, SauceSize size) {
		this.price = flavor.getPrice() * size.getModifier();
	}
}
