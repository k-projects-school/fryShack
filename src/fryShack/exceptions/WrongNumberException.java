package fryShack.exceptions;

import java.util.InputMismatchException;

public class WrongNumberException extends InputMismatchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongNumberException() {
		super();
	}
	
	public WrongNumberException(String message) {
		super(message);
	}
}
