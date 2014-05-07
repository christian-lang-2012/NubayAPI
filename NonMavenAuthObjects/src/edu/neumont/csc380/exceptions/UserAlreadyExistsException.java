package edu.neumont.csc380.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	
	static String message = "The user being asked to be created already exists.";
	
	public UserAlreadyExistsException() {
		super(message);
	}
}
