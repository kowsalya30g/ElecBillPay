package com.capgemini.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Address;
import com.capgemini.model.BillHistory;
import com.capgemini.model.Connection;
import com.capgemini.model.Customer;
import com.capgemini.repository.BillHistoryRepository;
import com.capgemini.repository.ConnectionRepository;
import com.capgemini.repository.CustomerRepository;

@Service
public class ConnectionServiceImpl implements ConnectionService{

	@Autowired
	private ConnectionRepository connectionRepo;

	@Autowired
	private BillHistoryRepository billHistoryRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Connection newConnectionRequest(Connection newConnection) {
		return connectionRepo.save(newConnection);
	}

	@Override
	public Customer searchCustomerByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		if(connectionRepo.findByConsumerNumber(consumerNumber)==null) {
			throw new NoSuchConnectionException("No such connection with given consumer number exists");
		}
		return connectionRepo.readCustomerByConsumerNumber(consumerNumber);
	}

	@Override
	public ResponseEntity<Object> modifyConnectionAddress(Long consumerNumber,Address address) throws NoSuchConnectionException{
		if(connectionRepo.findByConsumerNumber(consumerNumber)==null) {
			throw new NoSuchConnectionException("No such connection with given consumer number exists");
		}
		Connection newConnection = connectionRepo.findByConsumerNumber(consumerNumber);
		newConnection.setConnectionAddress(address);
		return new ResponseEntity<Object>(connectionRepo.save(newConnection),HttpStatus.OK);
		//return connectionRepo.updateConnectionAddress(newConnection);
	}

	@Override
	public List<Connection> findActiveConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		if(connectionRepo.readActiveConnectionsByVillage(villageName).isEmpty()) {
			throw new NoSuchConnectionException("No Active Connection Found for this Village");
		}
		return connectionRepo.readActiveConnectionsByVillage(villageName);
	}

	@Override
	public List<Connection> findActiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		if(connectionRepo.readActiveConnectionsByTaluka(taluka).isEmpty()) {
			throw new NoSuchConnectionException("No Active Connection Found for this Taluka");
		}
		return connectionRepo.readActiveConnectionsByTaluka(taluka);
	}

	@Override
	public List<Connection> findActiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
		if(connectionRepo.readActiveConnectionsByDistrict(districtName).isEmpty()) {
			throw new NoSuchConnectionException("No Active Connection Found for this District");
		}
		return connectionRepo.readActiveConnectionsByDistrict(districtName);
	}

	@Override
	public List<Connection> findActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		if(connectionRepo.readActiveConnectionsByPincode(pincode).isEmpty()) {
			throw new NoSuchConnectionException("No Active Connection Found for this PinCode");
		}
		return connectionRepo.readActiveConnectionsByPincode(pincode);
	}

	@Override
	public List<Connection> findInactiveConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		if(connectionRepo.readInactiveConnectionsByVillage(villageName).isEmpty()) {
			throw new NoSuchConnectionException("No Inactive Connection Found for this Village");
		}
		return connectionRepo.readInactiveConnectionsByVillage(villageName);
	}

	@Override
	public List<Connection> findInactiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		if(connectionRepo.readInactiveConnectionsByTaluka(taluka).isEmpty()) {
			throw new NoSuchConnectionException("No Inactive Connection Found for this Taluka");
		}
		return connectionRepo.readInactiveConnectionsByTaluka(taluka);
	}

	@Override
	public List<Connection> findInactiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
		if(connectionRepo.readInactiveConnectionsByDistrict(districtName).isEmpty()) {
			throw new NoSuchConnectionException("No Inactive Connection Found for this District");
		}
		return connectionRepo.readInactiveConnectionsByDistrict(districtName);
	}

	@Override
	public List<Connection> findInactiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		if(connectionRepo.readInactiveConnectionsByPincode(pincode).isEmpty()) {
			throw new NoSuchConnectionException("No Inactive Connection Found for this Pincode");
		}
		return connectionRepo.readInactiveConnectionsByPincode(pincode);
	}

	@Override
	public String deactivateConnection(Long consumerNumber, String email, String password) throws NoSuchConnectionException,InvalidLoginCredentialException {
		// TODO Auto-generated method stub
		if(!(email.equals("admin@gmail.com") && password.equals("Admin678")))
			throw new InvalidLoginCredentialException("Invalid Credentials. Only Admin can Perform this Task");

		Connection connection = connectionRepo.findByConsumerNumber(consumerNumber);
		if(connection==null)
			throw new NoSuchConnectionException("No Connection Record found for provided consumer Number");
		if(connection.getConnectionStatus()==false)
			throw new NoSuchConnectionException("Connection Already Deactivated");
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(connection.getConnectionDate(),LocalDate.now());

		BillHistory billHistory = billHistoryRepo.findBillHistoryByConsumerNumber(consumerNumber);
		if(noOfDaysBetween > 60 && (billHistory==null || billHistory.getLastPaidDate()==null))
		{
			connection.setConnectionStatus(false);
			connectionRepo.save(connection);
			return "Connection Deactivated";
		}
		else
		{
			 noOfDaysBetween = ChronoUnit.DAYS.between(billHistory.getLastPaidDate(),LocalDate.now());

			if(noOfDaysBetween>60)
			{
				connection.setConnectionStatus(false);
				connectionRepo.save(connection);
				return "Connection Deactivated";
			}
		}	
		return "Connection Not Eligible For  Deactivation";
	}
}