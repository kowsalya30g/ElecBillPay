package com.capgemini.exception;

public class NoSuchBillException extends RuntimeException {

	public NoSuchBillException()
	{

	}

	public NoSuchBillException(String message)
	{
		super(message);
	}
}
