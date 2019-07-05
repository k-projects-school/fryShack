package fryShack.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

import fryShack.enums.Menu;
import fryShack.enums.Menu.Item;
import fryShack.shop.Register;
import fryShack.shop.Stock;

class FryShack {
	/*
	 * The name of the fry shack
	 */
	private String name;
	
	/*
	 * The stock of the fry shack
	 */
	private Stock stock = new Stock();
	
	/*
	 * The register of the fry shack
	 */
	private Register register = new Register();

	/*
	 * The opening and closing hours
	 */
	private GregorianCalendar open = new GregorianCalendar(), closed = new GregorianCalendar();

	/**
	 * Constructor
	 * 
	 * @param name        - The name of the fry shack
	 * @param openingHour - The opening hour (only the hour, no minutes)
	 * @param closingHour - The closing hour (only the hour, no minutes)
	 */
	public FryShack(String name, int openingHour, int closingHour) {
		this.setName(name);
		this.setOpen(openingHour);
		this.setClosed(closingHour);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the open
	 */
	public GregorianCalendar getOpen() {
		return open;
	}

	/**
	 * @param openingHour the open to set
	 */
	public void setOpen(int openingHour) {
		this.open.set(Calendar.HOUR_OF_DAY, openingHour);
	}

	/**
	 * @return the closed
	 */
	public GregorianCalendar getClosed() {
		return closed;
	}

	/**
	 * @param closingHour the closed to set
	 */
	public void setClosed(int closingHour) {
		this.closed.set(Calendar.HOUR_OF_DAY, closingHour);
	}

	public void mainMenu() {
		System.out.println("Main menu: ");
		System.out.println("What would you like to do?");
		int index = 1;
		for (Menu menu : Menu.values()) {
			System.out.println("[" + (index++) + "] " + menu.getName());
		}
		System.out.print("\nChoose a number between 1 and " + (index - 1) + ": ");
		int response = HandleInput.processMainMenu();
		if (response > 0) {
			this.printSubMenu(response);
		}
	}

	public void printSubMenu(int response) {
		Menu menu = Menu.values()[response - 1];

		System.out.println(menu.getName() + ": ");

		int index = 1;
		for (Menu.Item menuItem : menu.getItems()) {
			String suffix = "";
			if (menuItem.getName().equals(Menu.Item.INIT_STOCK.getName())) {
				suffix = " (This resets the complete stock)";
			}
			System.out.println("[" + (index++) + "] " + menuItem.getName(true) + suffix);
		}
		System.out.println("[" + index + "] Return to main menu");
		System.out.print("\nChoose a number between 1 and " + index + ": ");

		response = HandleInput.processSubMenu(menu);
		if (response == -1) {
			this.mainMenu();
		} else if (response >= 0) {
			this.action(menu.getItems()[response - 1]);
		}
	}

	public void action(Item item) {
		switch (item) {
		case INIT_STOCK:
			this.stock.initStock();
			break;
		case FILL_STOCK:
			//this.stock.addItems(stockables);
			break;
		case LIST_STOCK:
			//this.stock.listItems();
			break;
		case PRINT_TICKETS_FOR_TODAY:
			this.register.printTicketsForToday();
			break;
		case PLACE_ORDER:
			//this.register.placeOrder();
			break;
		case PRINT_ALL_TICKETS:
			this.register.printAllTickets();
			break;
		}
	}

}
