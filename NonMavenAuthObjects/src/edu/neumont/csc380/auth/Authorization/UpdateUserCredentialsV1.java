package edu.neumont.csc380.auth.Authorization;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateUserCredentialsV1 {
	private String userName, newPassword, oldPassword;
	private AuthorityLevel authority;
	
	public UpdateUserCredentialsV1()
	{
		
	}
	
	public UpdateUserCredentialsV1(String userName,String newPassword,String oldPassword,AuthorityLevel authority)
	{
		this.userName = userName;
		this.newPassword = newPassword;
		this.oldPassword = oldPassword;
		this.authority = authority;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public AuthorityLevel getAuthority() {
		return authority;
	}
	public void setAuthority(AuthorityLevel authority) {
		this.authority = authority;
	}
}
