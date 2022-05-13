/*package com.capgemini.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;
import com.capgemini.services.CustomerServiceImplementation;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CustomerServiceImplementationTest {

	@MockBean
	private CustomerRepository repo;

	@Autowired
	private CustomerServiceImplementation service;

	Long customerId, adharNumber, userId;
	String firstName, middleName, lastName, mobileNumber, email, gender, userName, password, ans;

	Customer customer;

	@BeforeEach
	void setUp()
	{
		customerId = 210L;
		adharNumber = 671560739213L;
		firstName = "Pollai";
		middleName = "Shankar";
		lastName = "Gowri";
		mobileNumber = "9963548988";
		email = "pollaishankar@gmail.com";
		gender = "male";
		userId = 210L;
		userName = "pollaishankar@gmail.com";
		password = "pollai12";

		customer = new Customer(customerId, adharNumber,firstName, middleName,lastName, mobileNumber, email, gender,userId, userName,password);
		ans = customer.toString();
	}

	@Test
	public void registerCustomerTest()
	{
		when(repo.save(customer)).thenReturn(customer);
		assertEquals(ans,service.registerCustomer(customer));
	}

	@Test
	public void viewCustomerProfileTest()
	{
		when(repo.findCustomerByCustomerId(customerId)).thenReturn(customer);
		assertEquals(ans,service.viewCustomerProfile(customerId));	 
	}

	@Test
	public void searchCustomerByCustomerMobileNumberTest()
	{
		when(repo.findCustomerByMobileNumber(mobileNumber)).thenReturn(customer);
		assertEquals(ans,service.searchCustomerByMobile(mobileNumber));
	}

	@Test
	public void searchCustomerByCustomerAdharTest()
	{
		when(repo.findCustomerByAdharNumber(adharNumber)).thenReturn(customer);
		assertEquals(ans,service.searchCustomerByAdhar(adharNumber));
	}

	@Test
	public void searchCustomerByCustomerIdTest()
	{
		when(repo.findCustomerByCustomerId(customerId)).thenReturn(customer);
		assertEquals(ans,service.searchCustomerByCustomerId(customerId));
	}

	@Test
	public void searchCustomerByCustomerEmailTest()
	{
		when(repo.findCustomerByEmail(email)).thenReturn(customer);
		assertEquals(ans,service.searchCustomerByEmail(email));
	}
}

*/