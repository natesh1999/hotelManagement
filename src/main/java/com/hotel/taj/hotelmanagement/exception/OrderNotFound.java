package com.hotel.taj.hotelmanagement.exception;

public class OrderNotFound extends RuntimeException{
	
	private String message = "order not found";

	public String getMessage() {
		return message;
	}

	public OrderNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
