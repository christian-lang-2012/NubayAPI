package edu.neumont.csc380.auth.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.exceptions.InvalidPasswordException;
import edu.neumont.csc380.exceptions.UserAlreadyExistsException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;

public class UserFactory {

	private static ArrayList<User> users = new ArrayList<User>();
	private static TreeMap<String, User> userMap = new TreeMap<String, User>();
	private static int currentId = 0;
	
	public ArrayList<User> getUsers()
	{
		return UserFactory.users;
	}
	
	public User updateUser(String userName, String oldPass, String newPass,AuthorityLevel authority) throws UserDoesNotExistException 
	{
		User updatedUser = userMap.get(userName);
		
		if(updatedUser!=null)
		{
			if(!updatedUser.getPassword().equals(oldPass))
			{
				throw new InvalidPasswordException();
			}
			updatedUser.setAuthLevel(authority);
			updatedUser.setPassword(newPass);
		}
		else 
		{	
			throw new UserDoesNotExistException();
		}
		
		return updatedUser;
	}
	
	public Boolean createNewUser(User u)
	{
		Boolean created = false;
		u.setId(UserFactory.currentId++);
		Iterator it = userMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        User user = (User)pairs.getValue();
	        if(user.getUsername().equals(u.getUsername()))
	        {
	        	throw new UserAlreadyExistsException();
	        }
	    }
	    UserFactory.userMap.put(u.getUsername(), u);
		return  created;
	}
	public AuthorityLevel getAuthenticationLevel(String username)
	{
		User u = UserFactory.userMap.get(username);
		return u.getAuthLevel();
	}
	public User retrieveUser(String userName,String password) throws UserDoesNotExistException
	{
		User user = UserFactory.userMap.get(userName);
		
		if(user!=null)
		{
			if(!user.getPassword().equals(password))
			{
				throw new InvalidPasswordException();
			}
			
		}
		else throw new UserDoesNotExistException();
		return user;
	}
	public Boolean deleteUser(String userName)
	{
		return UserFactory.userMap.remove(userName) != null;
	}
}
