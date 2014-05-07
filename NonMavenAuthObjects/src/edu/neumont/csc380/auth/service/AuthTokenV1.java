package edu.neumont.csc380.auth.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthTokenV1 
{
	private String token;
	private int expiryMinutes;
	private int gioValue;
	private String message;
	
	public AuthTokenV1()
	{
		
	}
	
	public AuthTokenV1(String token,int gioValue,String message)
	{
		this.token = token;
		this.gioValue = gioValue;
		this.message = message;
		expiryMinutes = 20;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setExpiryMinutes(int expiryMinutes) {
		this.expiryMinutes = expiryMinutes;
	}

	public void setGioValue(int gioValue) {
		this.gioValue = gioValue;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getGioValue() {
		return gioValue;
	}
	
	public int getExpiryMinutes()
	{
		return expiryMinutes;
	}
	public String toString()
	{
		return "{authTokenV1{token: " + this.token + " expiryMinutes: " + expiryMinutes + " message: " + this.message+"}}";
	}
}
