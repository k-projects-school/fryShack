package fryShack.shop;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Register {
	private double totalCash, totalCredit;
	private HashMap<GregorianCalendar, Ticket[]> tickets = new HashMap<GregorianCalendar, Ticket[]>();
	private GregorianCalendar today = new GregorianCalendar();

	public Register() {
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
	}

	/**
	 * @return the totalCash
	 */
	public double getTotalCash() {
		return totalCash;
	}

	/**
	 * @return the totalCredit
	 */
	public double getTotalCredit() {
		return totalCredit;
	}

	/**
	 * @return the tickets
	 */
	public HashMap<GregorianCalendar, Ticket[]> getTickets() {
		return tickets;
	}

	/**
	 * Add a ticket to the register
	 * 
	 * @param ticket - The ticket to add
	 */
	public void addTicket(Ticket ticket) {
		Ticket[] tickets = this.tickets.get(today);
		if (tickets != null) {
			tickets = Arrays.copyOf(tickets, tickets.length + 1);
			tickets[tickets.length - 1] = ticket;
		} else {
			tickets = new Ticket[1];
			tickets[0] = ticket;
		}
		this.tickets.put(this.today, tickets);
	}

	/**
	 * Get the tickets for a specific day
	 * 
	 * @param calendar
	 * @return
	 */
	public Ticket[] getTicketsForDay(GregorianCalendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		return this.tickets.get(calendar);
	}

	/**
	 * Get the tickets for the current day
	 * 
	 * @return
	 */
	public Ticket[] getTicketsForToday() {
		return this.getTicketsForDay(this.today);
	}

	/**
	 * Print the tickets for a specific
	 * 
	 * @param calendar
	 */
	public void printTicketsForDay(GregorianCalendar calendar) {
		for (Ticket ticket : this.getTicketsForDay(calendar)) {
			ticket.print();
			System.out.println("------------");
		}
	}

	/**
	 * Print the tickets for a specific
	 * 
	 * @param calendar
	 */
	public void printTicketsForToday() {
		this.printTicketsForDay(today);
	}

	/**
	 * Print all the tickets in the register
	 */
	public void printAllTickets() {
		for (GregorianCalendar calendar : this.tickets.keySet()) {
			this.printTicketsForDay(calendar);
		}
	}
}
