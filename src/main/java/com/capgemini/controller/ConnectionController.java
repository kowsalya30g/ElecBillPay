package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Address;
import com.capgemini.model.Connection;
import com.capgemini.model.Customer;
import com.capgemini.services.ConnectionServiceImpl;

@RestController
public class ConnectionController {

	@Autowired
	private ConnectionServiceImpl connService;

	@PostMapping("/requestnewconnection")
	public Connection newConnectionRequest(@RequestBody Connection newConnection) {
		System.out.println("Adding New Connction");
		return connService.newConnectionRequest(newConnection);
	}

	@GetMapping(value="/searchCustomer/{consumerNo}")
	public Customer searchCustomerByConsumerNumber(@PathVariable("consumerNo") Long cNo) throws NoSuchCustomerException {
		return connService.searchCustomerByConsumerNumber(cNo);
	}

	@PatchMapping("/modifyConnectionAddress/{consumerNo}")
	public ResponseEntity<Object> modifyConnectionAddress(@PathVariable("consumerNo") Long cNo,@RequestBody Address address) {
		return connService.modifyConnectionAddress(cNo,address);
	}

	@GetMapping("/findActiveConnectionsByVillage/{villageName}")
	public ResponseEntity<Object> findActiveConnectionsByVillage(@PathVariable("villageName") String villageName) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findActiveConnectionsByVillage(villageName),HttpStatus.OK);
	}

	@GetMapping("/findActiveConnectionsByTaluka/{taluka}")
	public ResponseEntity<Object> findActiveConnectionsByTaluka(@PathVariable("taluka") String taluka) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findActiveConnectionsByTaluka(taluka),HttpStatus.OK);
	}

	@GetMapping("/findActiveConnectionsByDistrict/{districtName}")
	public ResponseEntity<Object> findActiveConnectionsByDistrict(@PathVariable("districtName") String districtName) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findActiveConnectionsByDistrict(districtName),HttpStatus.OK);
	}

	@GetMapping("/findActiveConnectionsByPincode/{pincode}")
	public ResponseEntity<Object> findActiveConnectionsByPincode(@PathVariable("pincode") String pincode) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findActiveConnectionsByPincode(pincode),HttpStatus.OK);
	}

	@GetMapping("/findInactiveConnectionsByVillage/{villageName}")
	public ResponseEntity<Object> findInactiveConnectionsByVillage(@PathVariable("villageName") String villageName) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findInactiveConnectionsByVillage(villageName),HttpStatus.OK);
	}

	@GetMapping("/findInactiveConnectionsByTaluka/{taluka}")
	public ResponseEntity<Object> findInactiveConnectionsByTaluka(@PathVariable("taluka") String taluka) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findInactiveConnectionsByTaluka(taluka),HttpStatus.OK);
	}

	@GetMapping("/findInactiveConnectionsByDistrict/{districtName}")
	public ResponseEntity<Object> findInactiveConnectionsByDistrict(@PathVariable("districtName") String districtName) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findInactiveConnectionsByDistrict(districtName),HttpStatus.OK);
	}

	@GetMapping("/findInactiveConnectionsByPincode/{pincode}")
	public ResponseEntity<Object> findInactiveConnectionsByPincode(@PathVariable("pincode") String pincode) throws NoSuchConnectionException{
		return new ResponseEntity<Object>(connService.findInactiveConnectionsByPincode(pincode),HttpStatus.OK);
	}
	
	@GetMapping("/DeactivateConnection/{consumerNumber}/{email}/{password}")
	public ResponseEntity<String> deactivateConnection(@PathVariable("consumerNumber") Long consumerNumber, @PathVariable("email") String email, @PathVariable("password") String password)
	{
		return new ResponseEntity<String>(connService.deactivateConnection(consumerNumber,email,password),HttpStatus.OK);
	}
}