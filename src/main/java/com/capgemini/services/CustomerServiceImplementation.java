package com.capgemini.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.exception.AadharNumberLengthException;
import com.capgemini.exception.DuplicateCustomerException;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.exception.PasswordLengthException;
import com.capgemini.exception.UserNameLengthException;
import com.capgemini.model.Customer;
import com.capgemini.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public String registerCustomer(Customer customer) throws DuplicateCustomerException,UserNameLengthException,AadharNumberLengthException
	{
		if(customerRepo.findCustomerByEmail(customer.getEmail())!=null)
			throw new DuplicateCustomerException("Customer account already exists with the provided Email");

		if(customerRepo.findCustomerByAdharNumber(customer.getAdharNumber())!=null)
			throw new DuplicateCustomerException("Customer account already exists with the provided Adhar Number");

		if(customerRepo.findCustomerByMobileNumber(customer.getMobileNumber())!=null)
			throw new DuplicateCustomerException("Customer account already exists with the same Mobile Number");

		if(customerRepo.findUserByUserName(customer.getUserName())!=null)
			throw new DuplicateUserException("User already Exists with the given username. please use other username");

		if(customer.getPassword().length()<8)
			throw new PasswordLengthException("Password should be 8 characters only");

		if(String.valueOf(customer.getAdharNumber()).length()!=12)
			throw new AadharNumberLengthException("Aadhar Number should be exactly 12 digits");

		customerRepo.save(customer);
		customer.setCustomerId(customer.getUserId());
		customerRepo.save(customer);
		return customer.toString();
	}


	@Override
	public String viewCustomerProfile(Long customerId) throws NoSuchCustomerException {
		Customer customer = customerRepo.findCustomerByCustomerId(customerId);
		if(customer==null)
			throw new NoSuchCustomerException("No customer exists with the provided CustomerId");
		return customer.toString();
	}

	@Override
	public String searchCustomerByCustomerId(Long id) throws NoSuchCustomerException{
		Customer customer = customerRepo.findCustomerByCustomerId(id);
		if(customer!=null)
			return customer.toString();
		throw new NoSuchCustomerException("No customer exists with the provided CustomerId");
	}

	@Override
	public String searchCustomerByEmail(String email) throws NoSuchCustomerException{
		Customer customer = customerRepo.findCustomerByEmail(email);
		if(customer!=null)
			return customer.toString();
		throw new NoSuchCustomerException("No customer exists with the provided Email");
	}

	public String searchCustomerByAdhar(Long adharNumber) throws NoSuchCustomerException{

		Customer customer = customerRepo.findCustomerByAdharNumber(adharNumber);
		if(customer!=null)
			return customer.toString();
		throw new NoSuchCustomerException("No customer exists with the provided Adhar Number");

	}

	@Override
	public String searchCustomerByMobile(String mobileNumber) throws NoSuchCustomerException {
		Customer customer = customerRepo.findCustomerByMobileNumber(mobileNumber);
		if(customer!=null)
			return customer.toString();
		throw new NoSuchCustomerException("No customer exists with the provided Mobile Number");
	}

	@Override
	public List<Long> searchCustomerByName(String firstName) throws NoSuchCustomerException {
		List<Long>customer = customerRepo.findCustomerByFirstName(firstName);
		if(customer.size()!=0)
			return customer;
		throw new NoSuchCustomerException("No customer exists with the provided First Name");
	}

	@Override
	public String editCustomerMobileNumber(Long id,String password, String mobileNumber) throws NoSuchCustomerException, DuplicateCustomerException {
		Customer customer=customerRepo.findCustomerByCustomerId(id);
		if(customer==null)
			throw new NoSuchCustomerException("No customer exists with the provided CustomerId");
		if(!customer.getPassword().equals(password))
			throw new NoSuchCustomerException("Your Password is Incorrect. This Action cannot be Done");
		if(customerRepo.findCustomerByMobileNumber(mobileNumber)!=null)
			throw new DuplicateCustomerException("Customer account already exists with the same Mobile Number");
		customer.setMobileNumber(mobileNumber);
		customerRepo.save(customer);
		return "Successfully updated Mobile Number";
	}

	@Override
	public String editCustomerEmail(Long id,String password, String email) throws NoSuchCustomerException, DuplicateCustomerException {
		Customer customer=customerRepo.findCustomerByCustomerId(id);
		if(customer==null)
			throw new NoSuchCustomerException("No customer exists with the provided CustomerId");
		if(!customer.getPassword().equals(password))
			throw new NoSuchCustomerException("Your Password is Incorrect. This Action cannot be Done");
		if(customerRepo.findCustomerByEmail(email)!=null)
			throw new DuplicateCustomerException("Customer account already exists with the provided Email");
		customer.setEmail(email);
		customerRepo.save(customer);
		return "Successfully updated Email";
	}
}

