package com.app.foodbox.exception;

public class CartNotFoundException  extends RuntimeException{

	public CartNotFoundException(String message)
	{
		super(message);
	}
}
