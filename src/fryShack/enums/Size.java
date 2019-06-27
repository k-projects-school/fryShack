package fryShack.enums;

public enum Size {
	MINI(1.8), SMALL(2.2), MEDIUM(2.5), LARGE(3), FAMILY(5);

	private double price;

	/**
	 * Constructor
	 * 
	 * @param price - The price of a size
	 */
	private Size(double price) {
		this.price = price;
	}

	/**
	 * Get the price
	 * 
	 * @return - The price
	 */
	public double getPrice() {
		return this.price;
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
