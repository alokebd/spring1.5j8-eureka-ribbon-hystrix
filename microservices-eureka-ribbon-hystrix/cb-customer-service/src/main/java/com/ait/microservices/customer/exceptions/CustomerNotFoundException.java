package com.ait.microservices.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
