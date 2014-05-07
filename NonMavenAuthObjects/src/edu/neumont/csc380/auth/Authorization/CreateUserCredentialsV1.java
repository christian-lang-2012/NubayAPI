package edu.neumont.csc380.auth.Authorization;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateUserCredentialsV1 {
	private String userName;
	private String password;
	private AuthorityLevel authority;
	
	public CreateUserCredentialsV1()
	{
		
	}
	
	public CreateUserCredentialsV1(String userName,String password,AuthorityLevel authority)
	{
		this.userName = userName;
		this.password = password;
		this.authority = authority;
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
	
	public AuthorityLevel getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityLevel authority) {
		this.authority = authority;
	}

	public String toString()
	{
		return " Username: " + this.userName;
	}
}
