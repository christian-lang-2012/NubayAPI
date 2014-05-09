package com.nubay.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.neumont.csc380.cms.model.Auction;
import edu.neumont.csc380.cms.model.Bid;

@Path("/item")
@Consumes("application/vnd.neumont.edu.auction-v1+json")
@Produces("application/vnd.neumont.edu.auction-v1+json")
public interface ItemService {
	@GET
	@Path("/{itemId}")
	Response getItem(@PathParam("itemId") Long id);

	@DELETE
	@Path("/{itemId}")
	Response deleteItem(@PathParam("itemId") Long id);

	@POST
	@Path("/")
	Response addItem(Auction item);

	@PUT
	@Path("/{itemId}")
	Response updateItem(@PathParam("itemId") Long id, Auction item);

	@GET
	@Path("/{itemId}/bid")
	Response getBid(@PathParam("itemId") Long id);

	@POST
	@Path("/{itemId}/bid")
	Response makeBid(@PathParam("itemId") Long id, Bid bid);

}
