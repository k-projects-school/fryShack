package fryShack.shop;

import java.time.Instant;
import java.util.UUID;

import fryShack.interfaces.Orderable;

public class Ticket {
	private Orderable[] items = new Orderable[0];
	private double totalSum = 0;
	private Instant date = Instant.now();
	private UUID id = UUID.randomUUID();

	/**
	 * Constructor
	 * 
	 * @param orderables - The items that are ordered
	 */
	public Ticket(Orderable... orderables) {
		this.items = orderables;
		this.calculateSum();
	}

	/**
	 * Calculate the total sum of the order
	 */
	private void calculateSum() {
		for (Orderable orderable : this.items) {
			this.totalSum += orderable.getPrice();
		}
	}
	
	/**
	 * Print a ticket
	 */
	public void print() {
		System.out.println("--- Ticket " + this.id + " ---");
		System.out.println(date);
		System.out.println();
		for (Orderable item : this.items) {
			System.out.printf(item.getName() + " --- €%.2f\n", item.getPrice());
		}
		System.out.println("------------");
		System.out.printf("Total: %.2f\n", this.totalSum);
	}
}
