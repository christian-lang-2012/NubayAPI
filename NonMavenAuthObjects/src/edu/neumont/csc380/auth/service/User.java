package edu.neumont.csc380.auth.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
@XmlRootElement
public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private AuthorityLevel authLevel;
	
	public User()
	{
		
	}
	
	public User(int id, String username, String password, AuthorityLevel authLevel) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authLevel = authLevel;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthorityLevel getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(AuthorityLevel authLevel) {
		this.authLevel = authLevel;
	}
	public boolean equals(Object o)
	{
		return ((User)o).getUsername().equals(this.getUsername());
	}
	
	public String toString()
	{
		return "ID: " + this.id + " Username: " + this.username + " AuthLevel: " +this.authLevel;
	}

}
