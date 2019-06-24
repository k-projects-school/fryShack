package fryShack.drinks;

import fryShack.enums.AlcoholType;

public class Alcohollic extends Drink {

	private double promille;

	/**
	 * Constructor
	 * 
	 * @param alcoholType - The type of alcoholic drink
	 */
	public Alcohollic(AlcoholType alcoholType) {
		this.setName(alcoholType.getName());
		this.setPrice(alcoholType.getPrice());
		this.setVolume(alcoholType.getVolume());
		this.promille = alcoholType.getPromille();
	}

	/**
	 * Get the promille
	 * 
	 * @return - The promille
	 */
	public double getPromille() {
		return this.promille;
	}
}
