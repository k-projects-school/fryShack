package fryShack.enums;

public enum Menu {
	STOCK(Menu.Item.INIT_STOCK, Menu.Item.FILL_STOCK, Menu.Item.LIST_STOCK),
	REGISTER(Menu.Item.PRINT_TICKETS_FOR_TODAY, Menu.Item.PRINT_ALL_TICKETS, Menu.Item.PLACE_ORDER);

	private Menu.Item[] submenu;

	/**
	 * Constructor
	 * 
	 * @param menuItems
	 */
	private Menu(Menu.Item... menuItems) {
		this.submenu = menuItems;
	}

	/**
	 * Get the sub menu
	 * 
	 * @return
	 */
	public Menu.Item[] getItems() {
		return this.submenu;
	}

	/**
	 * Get the name
	 * 
	 * @return
	 */
	public String getName() {
		return this.name().charAt(0) + this.name().toLowerCase().substring(1).replace('_', ' ');
	}

	public enum Item {
		INIT_STOCK, FILL_STOCK, LIST_STOCK, PRINT_TICKETS_FOR_TODAY, PLACE_ORDER, PRINT_ALL_TICKETS;

		/**
		 * Get the name
		 * 
		 * @return
		 */
		public String getName() {
			return this.name().toLowerCase().replace('_', ' ');
		}

		/**
		 * Get the name
		 * 
		 * @return
		 */
		public String getName(Boolean FirstLetterUppercase) {
			// If the first letter has to be upper case.
			if (FirstLetterUppercase) {
				return this.getName().toUpperCase().charAt(0) + this.getName().substring(1);
			}

			return this.getName();
		}
	}
}
