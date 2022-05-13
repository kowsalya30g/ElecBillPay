package com.capgemini.exception;

public class NoSuchConnectionException extends RuntimeException{

	public NoSuchConnectionException()
	{

	}
	public NoSuchConnectionException(String message)
	{
		super(message);
	}
}
