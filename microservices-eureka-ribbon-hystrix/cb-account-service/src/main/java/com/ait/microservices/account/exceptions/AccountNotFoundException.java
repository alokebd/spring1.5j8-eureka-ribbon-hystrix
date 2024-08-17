package com.ait.microservices.account.exceptions;

public class AccountNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
	}

	public AccountNotFoundException(String message) {
		super(message);
	}
	
}
