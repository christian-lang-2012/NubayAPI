package customExceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

/**
 * 
 * This is the hook to customize the handling
 *
 */
@Service     // for spring
@Provider   //for cxf
public class CustomExceptionHandler implements ExceptionMapper<CustomException>{

	public Response toResponse(CustomException exception)
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build(); 
    }
}
