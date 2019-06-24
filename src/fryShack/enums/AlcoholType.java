package fryShack.enums;

public enum AlcoholType {
	JUPILER(5.2, 2.5, 33), WESTMALLE(9.5, 3, 33) {
		@Override
		public String getName() {
			return super.getName() + " Trippel";
		}
	},
	KRIEK(3.5, 2.5, 33), JUPILER_NA(0.5, 2.5, 33) {
		@Override
		public String getName() {
			return super.getName().replace('_', ' ');
		}
	},
	KARMELIET(8.4, 3, 33) {
		@Override
		public String getName() {
			return "Trippel " + super.getName();
		}
	};

	private double promille, price;
	private int volume;

	/**
	 * Constructor
	 * 
	 * @param promille - The alcohol level
	 * @param price    - The price
	 */
	private AlcoholType(double promille, double price, int volume) {
		this.promille = promille;
		this.price = price;
		this.volume = volume;
	}

	/**
	 * Get the promille
	 * 
	 * @return - The promille
	 */
	public double getPromille() {
		return this.promille;
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
	 * Get the volume
	 * 
	 * @return - The volume
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
		return this.name().charAt(0) + this.name().toLowerCase().substring(1);
	}
}
