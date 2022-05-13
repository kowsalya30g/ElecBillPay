package com.capgemini.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.exception.AadharNumberLengthException;
import com.capgemini.exception.DuplicateCustomerException;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchBillException;
import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.exception.NoSuchUserException;
import com.capgemini.exception.PasswordLengthException;
import com.capgemini.exception.UserNameLengthException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(value=InvalidLoginCredentialException.class)
	public ResponseEntity<String> handleInvalidCredentialException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=NoSuchUserException.class)
	public ResponseEntity<String> handleNoSuchUserException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=DuplicateUserException.class)
	public ResponseEntity<String> handleDuplicateUserException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=NoSuchCustomerException.class)
	public ResponseEntity<String> NoSuchCustomerException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=DuplicateCustomerException.class)
	public ResponseEntity<String> handleDuplicateCustomerException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=PasswordLengthException.class)
	public ResponseEntity<String> handlePasswordLengthException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=UserNameLengthException.class)
	public ResponseEntity<String> handleUserNameLengthException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=AadharNumberLengthException.class)
	public ResponseEntity<String> handleAadharNumberLengthException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoSuchConnectionException.class)
	public ResponseEntity<Object> NoSuchConnectionHandler(Exception e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=NoSuchBillException.class)
	public ResponseEntity<String> handleNoSuchBillException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=InvalidAmountException.class)
	public ResponseEntity<String> handleInvalidAmountException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
