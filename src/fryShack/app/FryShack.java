package fryShack.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

class FryShack {
	/*
	 * The name of the fry shack
	 */
	private String name;
	
	/*
	 * The opening and closing hours
	 */
	private GregorianCalendar open = new GregorianCalendar(), closed = new GregorianCalendar();

	/**
	 * Constructor
	 * 
	 * @param name - The name of the fry shack
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

}
