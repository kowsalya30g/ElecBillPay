package com.capgemini.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.NoSuchBillException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Bill;
import com.capgemini.model.BillHistory;
import com.capgemini.model.Connection;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;
import com.capgemini.repository.BillHistoryRepository;
import com.capgemini.repository.BillRepository;
import com.capgemini.repository.ConnectionRepository;
import com.capgemini.repository.PaymentRepository;

@Service
public class PaymentServiceImplementation implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private BillRepository billRepo;

	@Autowired
	private BillHistoryRepository billHistoryRepo;

	@Autowired
	private BillHistory billHistory;

	@Autowired
	private ConnectionRepository connectionRepo;

	@Autowired
	private EmailSenderService emailService;

	@Override
	public PaymentStatus payBill(Payment payment) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		Long consumerNumber=payment.getConsumerNumber();
		BillHistory bill=billHistoryRepo.findBillHistoryByConsumerNumber(consumerNumber);
		Bill currentBill = billRepo.findBillByConsumerNumber(consumerNumber);
		Connection connection = connectionRepo.findByConsumerNumber(consumerNumber);

		if(bill==null)
			throw new NoSuchBillException("No Bill Generated for Provided Consumer Number");
		if(payment.getTotalPaid()<=0)
			throw new InvalidAmountException("Amount must be greater than Zero for Payment");

		bill.setBalanceDue(Math.round(bill.getBalanceDue()+checkForLateCharges(date,currentBill.getBillDueDate())-payment.getTotalPaid()));
		bill.setLastPaidDate(date);
		billHistoryRepo.save(bill);

		if((!connection.getConnectionStatus()) && bill.getBalanceDue()<=10)
		{
			activateConnection(connection);
		}

		sendEmailOnPaymentCompletion(payment);
		return PaymentStatus.SUCCESS;
	}

	@Override
	public void sendEmailOnPaymentCompletion(Payment payment) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		Long consumerNumber=payment.getConsumerNumber();
		BillHistory bill=billHistoryRepo.findBillHistoryByConsumerNumber(consumerNumber);
		String body = "Hi User. Your bill against consumer Number "+consumerNumber+" of rupees "+payment.getTotalPaid()+
				" is success on "+date+" ."+"\n"+"\n"+"And your Due Amount is "+String.format("%.2f",bill.getBalanceDue());

		emailService.sendSimpleEmail(payment.getEmail(), body,"Electricity Bill Payment Successfull");

	}

	@Override
	public BillHistory viewHistoricalPayment(Long consumerNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		BillHistory bill = billHistoryRepo.findBillHistoryByConsumerNumber(consumerNumber);
		if(bill==null)
			throw new NoSuchCustomerException("No Record Found");
		return bill;
	}

	@Override
	public int checkForLateCharges(LocalDate today,LocalDate dueDate)
	{
		int compare = today.compareTo(dueDate);
		if(compare>0)
			return 10;
		return 0;
	}

	@Override
	public void activateConnection(Connection connection)
	{
		connection.setConnectionStatus(true);
		connectionRepo.save(connection);
	}
}
