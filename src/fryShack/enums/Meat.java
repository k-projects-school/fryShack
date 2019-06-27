package fryShack.enums;

public enum Meat {
	CURRYWURST(2), MEATBALL(2.2), CHICKEN_FINGERS(2.5), HAMBURGER(3), TACO(2.25), VIANDEL(2.2), CHICKEN_NUGGETS(2.6),
	CURRYWURST_SPECIAL(2.8);
	
	private double price;
	
	/**
	 * Constructor
	 * 
	 * @param price - The price
	 */
	private Meat(double price) {
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
		return this.name().charAt(0) + this.name().toLowerCase().substring(1).replace('_', ' ');
	}
}
