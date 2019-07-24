package fryShack.app;

import fryShack.shop.FryShack;

public class App {

	public static void main(String[] args) {
		FryShack fryShack = new FryShack("Den gebakken patat", 9, 23);

		HandleInput.start();
		fryShack.mainMenu();
		HandleInput.end();
		
	}

}
