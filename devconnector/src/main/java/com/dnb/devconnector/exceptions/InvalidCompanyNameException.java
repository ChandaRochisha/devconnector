package com.dnb.devconnector.exceptions;

public class InvalidCompanyNameException extends Exception {
	public InvalidCompanyNameException(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}
}
