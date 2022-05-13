package com.capgemini.exception;

public class PasswordLengthException extends RuntimeException {

	public PasswordLengthException()
	{

	}

	public PasswordLengthException(String message)
	{
		super(message);
	}

}
