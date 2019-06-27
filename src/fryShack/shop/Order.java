package fryShack.shop;

import java.util.Arrays;

import fryShack.interfaces.Orderable;

public class Order {
	Orderable[] items = new Orderable[0];

	public Order(Orderable... orderables) {
		this.addItems(orderables);
	}

	/**
	 * Add multiple items to the order
	 * 
	 * @param orderables - The items to add
	 */
	public void addItems(Orderable... orderables) {
		for (Orderable orderable : orderables) {
			this.addItem(orderable);
		}
	}

	/**
	 * Add a item to the order
	 * 
	 * @param orderable - The item to add
	 */
	public void addItem(Orderable orderable) {
		this.items = Arrays.copyOf(this.items, this.items.length + 1);
		this.items[this.items.length - 1] = orderable;
	}
}
