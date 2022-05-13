package com.capgemini.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Address;
import com.capgemini.model.Connection;
import com.capgemini.model.Customer;

@Service
public interface ConnectionService {

	public Connection newConnectionRequest(Connection newConnection);
	public Customer searchCustomerByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;
	public ResponseEntity<Object> modifyConnectionAddress(Long consumerNumber,Address address);
	public List<Connection> findActiveConnectionsByVillage(String villageName)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByTaluka(String taluka)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByDistrict(String districtName)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByPincode(String pincode)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByVillage(String villageName)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByTaluka(String taluka)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByDistrict(String districtName)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByPincode(String pincode)throws NoSuchConnectionException;
	public String deactivateConnection(Long consumerNumber, String email, String password) throws NoSuchConnectionException, InvalidLoginCredentialException;

}