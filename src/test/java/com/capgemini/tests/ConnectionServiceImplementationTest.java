
/*package com.capgemini.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.model.Address;
import com.capgemini.model.Connection;
import com.capgemini.model.ConnectionType;
import com.capgemini.model.Customer;
import com.capgemini.repository.ConnectionRepository;
import com.capgemini.services.ConnectionServiceImpl;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class ConnectionServiceImplementationTest{
	
	Connection connection;
	Address address;
	Customer customer;
	Connection connection2;
	Address address2;
	
	@Autowired
	ConnectionServiceImpl connectionService;
	
	@MockBean
	private ConnectionRepository connectionRepo;

	@BeforeEach
	void setUp() throws Exception {
		
		connection = new Connection();
		address = new Address();
		
		address.setAddressId((long) 7);
		address.setBuildingName("XYZ");
		address.setFlatOrHouseNumber(123);
		address.setDistrict("A");
		address.setLandmark("SD");
		address.setPincode("123456");
		address.setState("MH");
		address.setTaluka("CN");
		address.setVillage("AC");
		
		connection.setConnectionCustomerId((long) 2);
		connection.setConnectionId((long) 8);
		connection.setConsumerNumber((long) 9);
		connection.setConnectionAddress(address);
		connection.setApplicationDate(LocalDate.now());
		connection.setConnectionDate(LocalDate.of(2022, 12, 12));
		connection.setConnectionType(ConnectionType.NON_INDUSTRIAL);
		connection.setConnectionStatus(true);
		
		connection2 = new Connection();
		address2 = new Address();
		
		address2.setAddressId((long) 10);
		address2.setBuildingName("ABC");
		address2.setFlatOrHouseNumber(34);
		address2.setDistrict("BN");
		address2.setLandmark("Tm");
		address2.setPincode("123456");
		address2.setState("MH");
		address2.setTaluka("CN");
		address2.setVillage("AC");
		
		connection2.setConnectionCustomerId((long) 11);
		connection2.setConnectionId((long) 12);
		connection2.setConsumerNumber((long) 13);
		connection2.setConnectionAddress(address2);
		connection2.setApplicationDate(LocalDate.now());
		connection2.setConnectionDate(LocalDate.of(2022, 10, 11));
		connection2.setConnectionType(ConnectionType.NON_INDUSTRIAL);
		connection2.setConnectionStatus(false);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNewConnectionRequest() {
		Mockito.when(connectionRepo.save(connection)).thenReturn(connection);
		assertThat(connectionService.newConnectionRequest(connection)).isEqualTo(connection);
	}

	@Test
	void testSearchCustomerByConsumerNumber() {
		customer = new Customer();
		customer.setCustomerId((long)2);
		customer.setAddharNumber((long) 123456);
		customer.setFirstName("Neha");
		customer.setLastName("AB");
		customer.setEmail("neha@gmail.com");
		customer.setGender("Female");
		customer.setMobileNumber("1234567890");
		
		Mockito.when(connectionRepo.readCustomerByConsumerNumber((long)9)).thenReturn(customer);
		Mockito.when(connectionRepo.findByConsumerNumber((long)9)).thenReturn(connection);
		assertThat(connectionService.searchCustomerByConsumerNumber((long)9)).isEqualTo(customer);
		
	}

	@Test
	void testFindActiveConnectionsByVillage() {
		List<Connection> connectionList = new ArrayList<>();
		connectionList.add(connection);
		
		Mockito.when(connectionRepo.readActiveConnectionsByVillage("AC")).thenReturn(connectionList);
		assertEquals(connectionList,connectionService.findActiveConnectionsByVillage("AC"));
		
	}

	@Test
	void testFindInactiveConnectionsByVillage() {
		List<Connection> connectionList = new ArrayList<>();
		connectionList.add(connection2);
		
		Mockito.when(connectionRepo.readInactiveConnectionsByVillage("AC")).thenReturn(connectionList);
		assertEquals(connectionList,connectionService.findInactiveConnectionsByVillage("AC"));
	}

}

*/