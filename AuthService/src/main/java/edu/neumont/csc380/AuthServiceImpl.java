package edu.neumont.csc380;
import java.io.IOException;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.auth.Authorization.AuthCredentialsV1;
import edu.neumont.csc380.auth.Authorization.CreateUserCredentialsV1;
import edu.neumont.csc380.auth.Authorization.Encryptor;
import edu.neumont.csc380.auth.Authorization.UpdateUserCredentialsV1;
import edu.neumont.csc380.auth.interfaces.IAuthService;
import edu.neumont.csc380.auth.service.AuthUser;
import edu.neumont.csc380.auth.service.User;
import edu.neumont.csc380.auth.service.UserFactory;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;

@Service("authService")
public class AuthServiceImpl implements IAuthService {
	private UserFactory userFactory = new UserFactory();
	private Encryptor encryptor = new Encryptor();

	public Response deleteUser(String username) throws UserDoesNotExistException {
		if(!userFactory.deleteUser(username))
		{
			throw new UserDoesNotExistException();
		}
		return Response.noContent().build();
	}

	public Response createUser(CreateUserCredentialsV1 streetCred)
	{
		Response response = null;
		User u = new User();
		u.setAuthLevel(streetCred.getAuthority());
		u.setPassword(streetCred.getPassword());
		u.setUsername(streetCred.getUserName());
		userFactory.createNewUser(u);
		AuthUser authUser = new AuthUser(u.getId(), u.getAuthLevel(),u.getUsername(),20);
		String message = "User " + u.getUsername() + " with the user id " + u.getId() + " and the authority level " + u.getAuthLevel() + " has been created";

		try {
			Encryptor encryptor = new Encryptor();
			response = Response.ok(encryptor.encryptUser(authUser, message)).build();
		} catch (Exception e) {
			response = Response.status(500).entity("There was a problem with the encryption of the user").build();
			e.printStackTrace();
		}
		return response;
	}

	public Response updateUserPassword(UpdateUserCredentialsV1 streetCred) throws UserDoesNotExistException, IOException
	{
		User user = userFactory.updateUser(streetCred.getUserName(), streetCred.getOldPassword(),streetCred.getNewPassword(),streetCred.getAuthority());
		if(user == null)
		{
			throw new UserDoesNotExistException();
		}
		AuthUser authUser = new AuthUser(user.getId(), user.getAuthLevel(), user.getUsername(), 20);
		return Response.ok(encryptor.encryptUser(authUser, "User " + streetCred.getUserName() + " has updated thier password.")).build();
	}


	public Response authorizeUser(AuthCredentialsV1 streetCred) throws UserDoesNotExistException, IOException
	{
		User user = userFactory.retrieveUser(streetCred.getUserName(),streetCred.getPassword());
		AuthUser authUser = new AuthUser(user.getId(), user.getAuthLevel(), user.getUsername(), 20);
		return Response.ok(encryptor.encryptUser(authUser, "User " + streetCred.getUserName() + " has updated thier password.")).build();
	}
}
