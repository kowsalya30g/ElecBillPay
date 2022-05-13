package com.capgemini.services;

import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.capgemini.model.BillHistory;
import com.capgemini.model.Connection;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;

@Service
public interface PaymentService {

	public PaymentStatus payBill(Payment payment);
	public void sendEmailOnPaymentCompletion(Payment payment);
	public BillHistory viewHistoricalPayment(Long consumerNumber);
	public int checkForLateCharges(LocalDate today,LocalDate dueDate);
	public void activateConnection(Connection connection);

}
