package fryShack.enums;

public enum ToppingType {
	LETTUCE, TOMATO, CAROT, CUCUMBER, EGG;

	/**
	 * Get the name
	 * 
	 * @return - The name
	 */
	public String getName() {
		return this.name().charAt(0) + this.name().toLowerCase().substring(1);
	}
}
