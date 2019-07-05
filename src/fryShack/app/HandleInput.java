package fryShack.app;

import java.util.Scanner;

import fryShack.enums.Menu;
import fryShack.exceptions.WrongNumberException;

public class HandleInput {
	private static Scanner kbd = new Scanner(System.in);

	/**
	 * Close the scanner object
	 */
	public static void end() {
		kbd.close();
	}

	/**
	 * Process the main menu
	 * 
	 * @return
	 */
	public static int processMainMenu() {
		try {
			// Get the response from the user
			int response = Integer.parseInt(kbd.next());

			// Determine what the highest number is that can be chosen
			int maxChoice = Menu.values().length;

			// If the response is lower than or equal to 0
			if (response <= 0) {
				throw new WrongNumberException("You have to choose a number higher than 0");
			}

			// If the response is higher than the max choice
			if (response > maxChoice) {
				throw new WrongNumberException("You have to choose a number lower than or equal to " + maxChoice);
			}

			return response;

		} catch (WrongNumberException e) {
			System.out.println(e.getMessage());
			return processMainMenu();
		}
	}

	/**
	 * Process a sub menu
	 * 
	 * @param menu
	 * @return
	 */
	public static int processSubMenu(Menu menu) {
		try {
			// Get the response from the user
			int response = Integer.parseInt(kbd.next());

			// Determine what the highest number is that can be chosen
			int maxChoice = menu.getItems().length + 1;

			// If the response is lower than or equal to 0
			if (response <= 0) {
				throw new WrongNumberException("You have to choose a number higher than 0");
			}

			// If the response is higher than the max choice
			if (response > maxChoice) {
				throw new WrongNumberException("You have to choose a number lower than or equal to " + maxChoice);
			}

			/*
			 * If the response is equal to the max choice, the user want's to go to the main
			 * menu
			 */
			if (response == maxChoice) {
				response = -1;
			}

			return response;

		} catch (WrongNumberException e) {
			System.out.println(e.getMessage());
			return processSubMenu(menu);
		}
	}

	public static int processInitStockStep1() {
		try {
			// Get the response from the user
			int response = Integer.parseInt(kbd.next());

			// Determine what the highest number is that can be chosen
			int maxChoice = 2;

			// If the response is lower than or equal to 0
			if (response <= 0) {
				throw new WrongNumberException("You have to choose a number higher than 0");
			}

			// If the response is higher than the max choice
			if (response > maxChoice) {
				throw new WrongNumberException("You have to choose a number lower than or equal to " + maxChoice);
			}
			
			return response;

		} catch (WrongNumberException e) {
			System.out.println(e.getMessage());
			return processInitStockStep1();
		}
	}

	public static int getPositiveInt() {
		try {
			// Get the response from the user
			int response = Integer.parseInt(kbd.next());
			
			// If the response is lower than or equal to 0
			if (response <= 0) {
				throw new WrongNumberException("You have to choose a number higher than 0");
			}
			
			return response;

		} catch (WrongNumberException e) {
			System.out.println(e.getMessage());
			return getPositiveInt();
		}
	}
}
