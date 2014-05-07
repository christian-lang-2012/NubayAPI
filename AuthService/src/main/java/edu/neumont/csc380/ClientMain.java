package edu.neumont.csc380;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;

public class ClientMain {
	public static void main(String[] args) throws InvalidTokenException
	{
		AuthClientImpl client = new AuthClientImpl();
		try {
			client.createUser("Tim", "isCanada",AuthorityLevel.User);
			client.updateUser("Tim","BOOM","isCanada",AuthorityLevel.Admin);
			client.authenticateUser("Tim", "BOOM");
			client.deleteUser("Tim");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
