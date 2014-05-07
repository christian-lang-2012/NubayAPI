package edu.neumont.csc380.exceptions;

public class InvalidTokenException extends Exception {
	private static String message = "The token recieved was not what was expected";
	
	public InvalidTokenException() {
		super(message); 
	}
}
