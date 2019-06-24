package fryShack.drinks;

import fryShack.enums.SodaFlavor;

public class SoftDrink extends Drink {
	
	/**
	 * Constructor
	 * 
	 * @param flavor - The flavor of the soft drink
	 */
	public SoftDrink(SodaFlavor flavor) {
		this.setName(flavor.getName());
		this.setPrice(flavor.getPrice());
		this.setVolume(flavor.getVolume());
	}
}
