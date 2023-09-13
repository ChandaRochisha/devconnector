package com.dnb.devconnector.exceptions;

public class InvalidProStatusException extends Exception{
	public InvalidProStatusException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
