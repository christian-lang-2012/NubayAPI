package edu.neumont.csc380.exceptions;

public class InvalidServerContentTypeException extends RuntimeException {
	
	static String message = "The content type sent was not accepted. Please send JSON";
	
	public InvalidServerContentTypeException() {
		super(message);
	}
}
