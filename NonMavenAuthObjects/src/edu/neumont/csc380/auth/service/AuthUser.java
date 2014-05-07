package edu.neumont.csc380.auth.service;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;

public class AuthUser {
	private int id;
	private String username;
	private AuthorityLevel authorityLevel;
	private Date expiry;
	
	public AuthUser(int id, AuthorityLevel authorityLevel, String username,int expiryMinutes) {
		super();
		this.username = username;
		this.id = id;
		this.authorityLevel = authorityLevel;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE,expiryMinutes);
		this.expiry = cal.getTime();
	}
	
	public int getId() {
		return id;
	}
	public AuthorityLevel getAuthorityLevel() {
		return authorityLevel;
	}

	public boolean hasExpired()
	{
		Date now = new Date();
		return expiry.before(now);
	}
	
	public String getUsername() {
		return username;
	}
	public boolean equals(Object o)
	{
		return ((AuthUser)o).getUsername().equals(this.getUsername());
	}
	
	public String toString()
	{
		return "ID: " + this.id + " Username: " + this.username + " AuthLevel: " +this.authorityLevel;
	}
}
