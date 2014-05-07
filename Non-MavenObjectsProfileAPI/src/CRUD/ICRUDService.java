package CRUD;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import customExceptions.CustomException;

import ProfileObjects.profile.Profile;


@Path("/manageProfile")
@Consumes("application/json")
@Produces("application/json")
public interface ICRUDService {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	Response getProfile(@PathParam("id")int id)throws CustomException;

	
	@PUT
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	Response updateProfile(@PathParam("id")int id, Profile profile)throws CustomException;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	Response createProfile(Profile profile) throws CustomException;
	
	@DELETE
	@Path("/{id}")
	Response deleteProfile(@PathParam("id")int id)throws CustomException;

}
