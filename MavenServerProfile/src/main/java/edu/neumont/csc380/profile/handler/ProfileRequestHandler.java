package edu.neumont.csc380.profile.handler;

import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;

@Provider
public class ProfileRequestHandler implements RequestHandler {

	public Response handleRequest(Message message, ClassResourceInfo cri) {
		System.out.println("message.size: " + message.size());
		String requestMethod = (String) message.get(message.HTTP_REQUEST_METHOD);
		
		
		TreeMap<String,Object> thisThing =  (TreeMap<String, Object>) message.get(message.PROTOCOL_HEADERS);
		System.out.println("thisThing: "+thisThing);
		
		Object o = thisThing.get("Authorization");
		System.out.println(o);
		
		if (requestMethod.equals("POST")) {
			System.out.println("It's a POST!");
			//Check auth
		}
		else if (requestMethod.equals("PUT")) {
			System.out.println("It's a PUT!");
			//Check auth
			
		} else if (requestMethod.equals("DELETE")) {
			System.out.println("It's a DELETE!");
			//Check auth
		}
		
		System.out.println("Auth \"accepted\"!");
		return null;
	}
/***
 * Need to use 401 (no auth) and 403 (forbidden, incorrect auth)
 */
}
