package edu.neumont.csc380.auth.interfaces;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.neumont.csc380.auth.Authorization.AuthCredentialsV1;
import edu.neumont.csc380.auth.Authorization.CreateUserCredentialsV1;
import edu.neumont.csc380.auth.Authorization.UpdateUserCredentialsV1;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;

@Path("/auth")
public interface IAuthService {
	@POST
	@Path("/authorize")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	public Response authorizeUser(AuthCredentialsV1 streetCred) throws UserDoesNotExistException, IOException;

	@PUT
	@Path("/updatePass")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	public Response updateUserPassword(UpdateUserCredentialsV1 streetCred)  throws UserDoesNotExistException, IOException;
	
	@DELETE
	@Path("/deleteUser/{username}")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	public Response deleteUser(@PathParam("username") String username) throws UserDoesNotExistException;
	
	@POST
	@Path("/create")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	@Produces("application/json")
	public Response createUser(CreateUserCredentialsV1 streetCred);
}
