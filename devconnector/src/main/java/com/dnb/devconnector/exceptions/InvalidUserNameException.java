package com.dnb.devconnector.exceptions;

public class InvalidUserNameException extends Exception{
	public InvalidUserNameException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
