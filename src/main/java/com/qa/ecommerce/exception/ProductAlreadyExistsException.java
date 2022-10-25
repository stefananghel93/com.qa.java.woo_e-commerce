package com.qa.ecommerce.exception;

public class ProductAlreadyExistsException extends Exception {
	
	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}
}
