package edu.neumont.csc380;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.ws.rs.MessageProcessingException;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

import edu.neumont.csc380.auth.Authorization.AuthCredentialsV1;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.Authorization.CreateUserCredentialsV1;
import edu.neumont.csc380.auth.Authorization.Encryptor;
import edu.neumont.csc380.auth.Authorization.UpdateUserCredentialsV1;
import edu.neumont.csc380.auth.interfaces.IAuthService;
import edu.neumont.csc380.auth.service.AuthTokenV1;
import edu.neumont.csc380.auth.service.AuthUser;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;


public class AuthClientImpl{
	private final IAuthService proxy;
	JSONProvider<Object> jsonProvider;
	
	public AuthClientImpl()
	{
		JSONProvider<Object> jsonProvider = new JSONProvider<Object>();
		jsonProvider.setIgnoreNamespaces(true);
		proxy = JAXRSClientFactory.create ( "http://localhost:8080/hellorest-server/rest", IAuthService.class,Arrays.asList(jsonProvider),true);
	}
	
	public AuthUser createUser(String userName,String password,AuthorityLevel authority) throws InvalidTokenException, UserDoesNotExistException
	{
		CreateUserCredentialsV1 streetCred = new CreateUserCredentialsV1(userName, password, authority);
		AuthUser authUser = null;
		Response r = proxy.createUser(streetCred);
		System.out.println(r);
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(AuthTokenV1.class).getToken());
		Encryptor encryptor = new Encryptor();
		try {
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authUser;
	}
	
	public AuthUser authenticateUser(String userName,String password) throws UserDoesNotExistException, InvalidTokenException
	{
		AuthCredentialsV1 streetCred = new AuthCredentialsV1(userName, password);
		AuthUser authUser = null;
		try {
			Response r = proxy.authorizeUser(streetCred);
			System.out.println(r);
			System.out.println(r.getStatus());
			System.out.println(r.readEntity(AuthTokenV1.class).getToken());
			Encryptor encryptor = new Encryptor();
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authUser;
	}
	
	public void deleteUser(String username) throws UserDoesNotExistException
	{
		proxy.deleteUser(username);
		System.out.println("BOOM! \n-Tim Toth");
	}

	
	public AuthUser updateUser(String userName,String newPassword,String oldPassword,AuthorityLevel authority) throws UserDoesNotExistException, IllegalStateException, InvalidTokenException
	{
		UpdateUserCredentialsV1 streetCred = new UpdateUserCredentialsV1(userName, newPassword, oldPassword, authority);
		AuthUser authUser = null;
		try {
			Response r = proxy.updateUserPassword(streetCred);
			System.out.println(r);
			System.out.println(r.getStatus());
			System.out.println(r.readEntity(AuthTokenV1.class).getToken());
			Encryptor encryptor = new Encryptor();
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authUser;
	}
}
