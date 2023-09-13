package com.dnb.devconnector.exceptions;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
