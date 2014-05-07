package edu.neumont.csc380.auth.Authorization;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthCredentialsV1 {
	private String userName;
	private String password;
	
	public AuthCredentialsV1()
	{
		
	}
	
	public AuthCredentialsV1(String userName,String password)
	{
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		return " Username: " + this.userName;
	}
}