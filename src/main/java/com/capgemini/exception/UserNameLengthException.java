package com.capgemini.exception;

public class UserNameLengthException extends RuntimeException{

	public UserNameLengthException()
	{

	}

	public UserNameLengthException(String message)
	{
		super(message);
	}

}
