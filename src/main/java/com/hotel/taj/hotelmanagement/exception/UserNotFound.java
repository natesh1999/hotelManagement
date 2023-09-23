package com.hotel.taj.hotelmanagement.exception;

public class UserNotFound extends RuntimeException {
	
	private String message = "user id not found";

	public String getMessage() {
		return message;
	}

	public UserNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
