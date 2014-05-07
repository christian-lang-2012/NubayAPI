package edu.neumont.csc380.exceptions;

public class InvalidPasswordException extends RuntimeException {

	static String message = "The password sent was invalid.";
	
	public InvalidPasswordException() {
		super(message);
	}
	
}
