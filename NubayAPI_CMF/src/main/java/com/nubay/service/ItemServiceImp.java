package com.nubay.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.cms.model.Auction;
import edu.neumont.csc380.cms.model.Bid;
import edu.neumont.csc380.cms.model.CMSData;

@Service("ItemService")
public class ItemServiceImp implements ItemService {

	public Response getItem(Long id) {
		Auction media = CMSData.getInstance().getAuction(id);

		if (media == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(media).build();
		}
	}

	public Response deleteItem(Long id) {
		Auction auction = CMSData.getInstance().removeAuction(id);

		if (auction == null) {
			return Response.status(404).build();
		} else {
			return Response.status(204).build();
		}
	}

	public Response addItem(Auction item) {
		CMSData.getInstance().addAuction(0L, item);
		return Response.status(201).build();
	}

	public Response updateItem(Long id, Auction item) {
		Auction media = CMSData.getInstance().getAuction(id);

		if (media == null) {
			return Response.status(404).build();
		} else {
			CMSData.getInstance().addAuction(id, item);
			return Response.ok(media).build();
		}
	}

	public Response getBid(Long id) {
		Auction item = CMSData.getInstance().getAuction(id);

		if (item == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(item.getBid()).build();
		}
	}

	public Response makeBid(Long id, Bid bid) {
		Auction item = CMSData.getInstance().getAuction(id);

		if (item == null) {
			return Response.status(404).build();
		} else {
			CMSData.getInstance().getAuction(id).setBid(bid);
			return Response.ok(item).build();
		}
	}

}
