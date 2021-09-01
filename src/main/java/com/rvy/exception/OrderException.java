package com.rvy.exception;

public class OrderException extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderException() {
		super("Unable to receive order");
	}

	public OrderException(String message) {
		super(message);
	}

	public OrderException(String message, Throwable e) {
		super(message, e);
	}
}
