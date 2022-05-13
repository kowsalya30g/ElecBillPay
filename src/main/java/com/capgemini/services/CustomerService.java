package com.capgemini.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.capgemini.exception.AadharNumberLengthException;
import com.capgemini.exception.DuplicateCustomerException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.exception.UserNameLengthException;
import com.capgemini.model.Customer;

@Service
public interface CustomerService {

	public String registerCustomer(Customer customer)throws DuplicateCustomerException,UserNameLengthException,AadharNumberLengthException;
	public String viewCustomerProfile(Long customerId)throws NoSuchCustomerException;
	public String editCustomerMobileNumber(Long customerId,String password,String mobileNumber)throws NoSuchCustomerException;
	public String editCustomerEmail(Long customerId,String password,String email)throws NoSuchCustomerException;
	public String searchCustomerByCustomerId(Long customerId)throws NoSuchCustomerException;
	public String searchCustomerByEmail(String email)throws NoSuchCustomerException;
	public String searchCustomerByAdhar(Long adharNumber)throws NoSuchCustomerException;
	public String searchCustomerByMobile(String mobile)throws NoSuchCustomerException;
	public List<Long> searchCustomerByName(String customerName)throws NoSuchCustomerException;
	
}
