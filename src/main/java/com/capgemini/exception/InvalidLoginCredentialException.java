package com.capgemini.exception;

public class InvalidLoginCredentialException extends RuntimeException {

	public InvalidLoginCredentialException()
	{

	}

	public InvalidLoginCredentialException(String message)
	{
		super(message);
	}
}
