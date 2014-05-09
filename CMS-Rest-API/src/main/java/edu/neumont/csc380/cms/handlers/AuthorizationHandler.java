package edu.neumont.csc380.cms.handlers;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;

@Provider
public class AuthorizationHandler implements RequestHandler {

	public Response handleRequest(Message m, ClassResourceInfo info) {
		String method = (String) m.get(Message.HTTP_REQUEST_METHOD);
		if (method.equals("POST") || method.equals("PUT")
				|| method.equals("DELETE")) {
			String token = getToken(m);
			if (token == null) {
				return Response.status(Status.UNAUTHORIZED).build();
			} else {
				// AuthClientImpl auth = new AuthClientImpl();
				// auth.
			}
		}
		return null;
	}

	private String getToken(Message m) {
		try {
			return ((ArrayList<String>) ((Map<String, ArrayList<String>>) m
					.get(Message.PROTOCOL_HEADERS)).get("Authorization"))
					.get(0);
		} catch (NullPointerException e) {
			return null;
		}
	}

}