package com.hotel.taj.hotelmanagement.exception;

public class ItemNotFound extends RuntimeException{
	
	private String message="item not found";

	public String getMessage() {
		return message;
	}

	public ItemNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
