package com.capgemini.services;

import java.io.IOException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.capgemini.exception.NoSuchBillException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Bill;
import com.capgemini.model.BillHistory;
import com.capgemini.model.ConnectionType;
import com.capgemini.model.FileUploadUtil;
import com.capgemini.model.Reading;
import com.capgemini.repository.BillHistoryRepository;
import com.capgemini.repository.BillRepository;
import com.capgemini.repository.ConnectionRepository;

@Service
public class BillServiceImplementation implements BillService{

	@Autowired
	private BillRepository billRepo;

	@Autowired
	private ConnectionRepository connRepo;

	@Autowired
	private BillHistoryRepository billHistoryRepo;

	@Autowired
	private EmailSenderService emailService;

	@Autowired
	private BillHistory billHistory;

	@Autowired
	private BillCalculatorService billCalculator;

	@Override
	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		if(billRepo.findBillByConsumerNumber(consumerNumber)!=null)
			return billRepo.findBillByConsumerNumber(consumerNumber);
		throw new NoSuchCustomerException("No Bill Exists for the Provided Consumer Number");
	}

	@Override
	public String emailBillToCustomer(Long consumerNumber,String email) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		if(billRepo.findBillByConsumerNumber(consumerNumber)==null)
			throw new NoSuchCustomerException("No Bill Exists for the Provided Consumer Number");
		String bill="Hi Please find your Electricity Bill "+"\n"+"\n"+"Consumer Number  :  "+consumerNumber+"\n"+"\n"+String.valueOf(billRepo.findBillByConsumerNumber(consumerNumber));
		emailService.sendSimpleEmail(email,bill ,"Electricity Bill");
		return "Bill is sent to Your Mail";	
	}

	@Override
	public String createBill(Long consumerNumber, int unitsConsumed,MultipartFile multipartFile) throws IOException
	{
		if(connRepo.findByConsumerNumber(consumerNumber)==null)
			throw new NoSuchCustomerException("No Connection Exists with the Provided Consumer Number");

		if(billRepo.findBillByConsumerNumber(consumerNumber)!=null)
		{
			Bill oldBill = billRepo.findBillByConsumerNumber(consumerNumber);
			billRepo.delete(oldBill);
		}

		String readingPhotoName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Reading newReading = new Reading();
		newReading.setConsumerNumber(consumerNumber);
		newReading.setUnitsConsumed(unitsConsumed);
		LocalDate date=LocalDate.now();
		newReading.setReadingDate(date);
		String uploadDir = "reading-photos/" + newReading.getConsumerNumber()+"_"+newReading.getReadingId();
		String path = FileUploadUtil.saveFile(uploadDir, readingPhotoName, multipartFile);
		System.out.println(path);
		newReading.setReadingPhoto(path+readingPhotoName);
		Bill bill = new Bill();
		bill.setBillForReading(newReading);
		bill.setBillDate(date);
		bill.setUnitsConsumed(unitsConsumed);
		billRepo.save(bill);
		GenerateBill(consumerNumber);
		return "Bill Generated and Saved Successfully";
	}

	@Override
	public void GenerateBill(Long consumerNumber) {
		// TODO Auto-generated method stub
		if(connRepo.findByConsumerNumber(consumerNumber)==null)
			throw new NoSuchCustomerException("No Connection Exists with the Provided Consumer Number");
		Bill bill=billRepo.findBillByConsumerNumber(consumerNumber);
		if(bill==null)
			throw new NoSuchBillException("No Bill Generated for Provided Consumer Number");
		ConnectionType type=connRepo.findByConsumerNumber(consumerNumber).getConnectionType();
		double amount=energeyBillCalculator(type,bill.getUnitsConsumed());
		bill.setBillAmount(amount);
		bill.setBillDueDate(getLastDateOfMonth());
		billRepo.save(bill);
		System.out.println("tested");
		BillHistory billHistoryPrev=billHistoryRepo.findBillHistoryByConsumerNumber(consumerNumber);
		if(billHistoryPrev!=null)
		{
			billHistoryPrev.setBalanceDue(billHistoryPrev.getBalanceDue()+amount);
			billHistoryRepo.save(billHistoryPrev);

		}
		else
		{
			billHistory.setConsumerNumber(consumerNumber);
			billHistory.setBalanceDue(amount);
			billHistory.setLastPaidDate(null);
			billHistoryRepo.save(billHistory);
		}
	}

	@Override
	public double energeyBillCalculator(ConnectionType type, int unitsConsumed) {
		// TODO Auto-generated method stub
		return billCalculator.calculateBill(unitsConsumed,type);
	}

	public LocalDate getLastDateOfMonth()
	{
		LocalDate currentDate=LocalDate.now();
		LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.getMonth().length(currentDate.isLeapYear()));
		return lastDayOfMonth;
	}
}
