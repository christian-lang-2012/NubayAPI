package edu.neumont.csc380.exceptions;

import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Throwable> {

	HashMap<Class<?>, Status> responseMap = new HashMap<Class<?>, Status>();
	
	public CustomExceptionMapper() {
		responseMap.put(InvalidPasswordException.class, Status.BAD_REQUEST);
		responseMap.put(InvalidServerCredentialsException.class, Status.PRECONDITION_FAILED);
		responseMap.put(InvalidServerContentTypeException.class, Status.BAD_REQUEST);
		responseMap.put(UserAlreadyExistsException.class, Status.CONFLICT);
		responseMap.put(UserDoesNotExistException.class, Status.NOT_FOUND);
		
	}
	
	public Response toResponse(Throwable arg0) {
		if(responseMap.containsKey(arg0.getClass())){
			return Response.status(responseMap.get(arg0.getClass())).build();
		}
		else{
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
