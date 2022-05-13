package com.capgemini.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capgemini.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	public Customer save(Customer customer);
	public Customer findCustomerByCustomerId(Long customerId);
	public Customer findCustomerByEmail(String email);
	public Customer findCustomerByAdharNumber(long adharNumber);
	public Customer findCustomerByMobileNumber(String mobile);

	@Query("select customer.customerId from Customer customer where customer.firstName=:firstName")
	public List<Long> findCustomerByFirstName(@Param("firstName") String firstName);

	public Customer findUserByUserName(String userName);

}
