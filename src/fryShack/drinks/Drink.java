package fryShack.drinks;

import fryShack.interfaces.Orderable;
import fryShack.interfaces.Stockable;

public abstract class Drink implements Orderable, Stockable {
	private String name;
	private double price;
	private int volume;
	
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
