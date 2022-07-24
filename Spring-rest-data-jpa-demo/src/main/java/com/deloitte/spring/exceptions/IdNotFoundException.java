package com.deloitte.spring.exceptions;

public class IdNotFoundException extends RuntimeException {
	
	String message;

	public IdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "IdNotFoundException [message=" + message + "]";
	}
	
	

}
