package fryShack.enums;

public enum SodaFlavor {
	FLAT_WATER_33(1.5, 33), SPARKLING_WATER_33(1.5, 33), COLA_33(2.2, 33), SPRITE_33(2.2, 33), FANTA_33(2.2, 33),
	COLA_ZERO_33(2.2, 33), FUSE_TEA_33(2.5, 33), FUSE_TEA_SPARKLING_33(2.5, 33), FLAT_WATER_50(2, 50),
	SPARKLING_WATER_50(2, 50), COLA_50(2.75, 50), SPRITE_50(2.75, 50), FANTA_50(2.75, 50), COLA_ZERO_50(2.75, 50),
	FUSE_TEA_50(3, 50), FUSE_TEA_SPARKLING_50(3, 50);

	private double price;
	private int volume;

	/**
	 * Constructor
	 * 
	 * @param price  - The price of the soda
	 * @param volume - The volume of the soda
	 */
	private SodaFlavor(double price, int volume) {
		this.price = price;
		this.volume = volume;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return this.volume;
	}

	/**
	 * Get the name
	 * 
	 * @return - The name
	 */
	public String getName() {
		return this.name().charAt(0) + this.name().toLowerCase().substring(1).replace('_', ' ') + " cl";
	}
}
