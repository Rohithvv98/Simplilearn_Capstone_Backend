package com.app.foodbox.exception;

public class UserCartNotFoundException extends RuntimeException{

	public UserCartNotFoundException(String message)
	{
		super(message);
	}

}
