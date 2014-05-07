package edu.neumont.csc380.exceptions;

public class UserDoesNotExistException extends Exception {
	
	static String message = "The user that is being reqeusted doesn't exists";
	
	public UserDoesNotExistException() {
		super(message);
	}
	
}
