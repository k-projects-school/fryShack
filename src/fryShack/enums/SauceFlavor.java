package fryShack.enums;

public enum SauceFlavor {
	MAYONAISE(0.5), KETCHUP(0.5), MAMOET(0.5), JOPPIE(0.5), TARTAAR(0.5), SPECIAL(0.7), SAMURAI(0.5), ANDALOUSE(0.5);

	private double price;

	/**
	 * Constructor
	 * 
	 * @param price - The price
	 */
	private SauceFlavor(double price) {
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Get the name
	 * 
	 * @return - The name
	 */
	public String getName() {
		return this.name().charAt(0) + this.name().toLowerCase().substring(1);
	}
}
