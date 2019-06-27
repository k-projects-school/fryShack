package fryShack.enums;

public enum SauceSize {
	MINI(0.8), SMALL(1), MEDIUM(1.5), LARGE(2), ON(1);

	private double modifier;

	/**
	 * Constructor
	 * 
	 * @param price - The modifier of a size
	 */
	private SauceSize(double modifier) {
		this.modifier = modifier;
	}

	/**
	 * Get the price
	 * 
	 * @return - The price
	 */
	public double getModifier() {
		return this.modifier;
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
