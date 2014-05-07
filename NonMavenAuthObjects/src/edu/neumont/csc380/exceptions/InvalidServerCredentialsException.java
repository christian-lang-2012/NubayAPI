package edu.neumont.csc380.exceptions;

public class InvalidServerCredentialsException extends RuntimeException {

	static String message = "The credentials that were sent are not accepted.";
	
	public InvalidServerCredentialsException() {
		super(message);
	}
	
}
