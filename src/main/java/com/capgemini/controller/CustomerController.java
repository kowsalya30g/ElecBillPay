package com.capgemini.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.model.Customer;
import com.capgemini.services.CustomerServiceImplementation;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImplementation customerService;

	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<String>(customerService.registerCustomer(customer),HttpStatus.OK);
	}

	@GetMapping("/viewCustomerProfile/{customerId}")
	public ResponseEntity<String> viewCustomerProfile(@PathVariable("customerId") Long customerId)
	{
		return new ResponseEntity<String>(customerService.viewCustomerProfile(customerId),HttpStatus.OK);
	}

	@GetMapping("/searchCustomerByCustomerId/{CustomerId}")
	public ResponseEntity<String> searchCustomerByCustomerId(@PathVariable("CustomerId") Long CustomerId)
	{
		return new ResponseEntity<String>(customerService.searchCustomerByCustomerId(CustomerId),HttpStatus.OK);
	}

	@GetMapping("/searchCustomerByEmail/{email}")
	public ResponseEntity<String> searchCustomerByEmail(@PathVariable("email") String email)
	{
		return new ResponseEntity<String>(customerService.searchCustomerByEmail(email),HttpStatus.OK);
	}

	@GetMapping("/searchCustomerByAdhar/{adharNumber}")
	public ResponseEntity<String> searchCustomerByAdhar(@PathVariable("adharNumber") Long adharNumber)
	{
		return new ResponseEntity<String>(customerService.searchCustomerByAdhar(adharNumber),HttpStatus.OK);
	}

	@GetMapping("/searchCustomerByMobile/{mobileNumber}")
	public ResponseEntity<String> searchCustomerByMobile(@PathVariable("mobileNumber") String mobileNumber)
	{
		return new ResponseEntity<String>(customerService.searchCustomerByMobile(mobileNumber),HttpStatus.OK);
	}

	@GetMapping("/searchCustomerByName/{firstName}")
	public ResponseEntity<List<Long>> searchCustomerIdByFirstName(@PathVariable("firstName") String firstName)
	{
		return new ResponseEntity<List<Long>>(customerService.searchCustomerByName(firstName),HttpStatus.OK);
	}

	@GetMapping("/editCustomerMobileNumber/{CustomerId}/{password}/{mobileNumber}")
	public ResponseEntity<String> editCustomerMobileNumber(@Valid @PathVariable("CustomerId") long CustomerId,@PathVariable("password") String password,@PathVariable("mobileNumber") String mobileNumber)
	{
		return new ResponseEntity<String>(customerService.editCustomerMobileNumber(CustomerId,password,mobileNumber),HttpStatus.OK);
	}

	@GetMapping("/editCustomerEmail/{CustomerId}/{password}/{email}")
	public ResponseEntity<String> editCustomerEmail(@Valid @PathVariable("CustomerId") long id,@PathVariable("password") String password,@PathVariable("email") String email)
	{
		return new ResponseEntity<String>(customerService.editCustomerEmail(id,password,email),HttpStatus.OK);
	}



}
