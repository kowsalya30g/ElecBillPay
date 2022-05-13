package com.capgemini.exception;

public class DuplicateCustomerException extends RuntimeException{

	public DuplicateCustomerException()
	{

	}
	public DuplicateCustomerException(String message)
	{
		super(message);
	}

}
