package com.capgemini.services;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Bill;
import com.capgemini.model.ConnectionType;

@Service
public interface BillService {

	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException;
	public String createBill(Long consumerNumber, int unitsConsumed, MultipartFile multipartFile) throws IOException;
	public String emailBillToCustomer(Long consumerNumber, String email)throws NoSuchCustomerException;
	public void GenerateBill(Long consumerNumber);
	public double energeyBillCalculator(ConnectionType type, int unitsConsumed);

}
