/*package com.capgemini.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.model.BillHistory;
import com.capgemini.repository.BillHistoryRepository;
import com.capgemini.services.PaymentServiceImplementation;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class PaymentServiceImplementationTest {

	@MockBean
	private BillHistoryRepository repo;

	@Autowired
	private PaymentServiceImplementation service;

	private Long billHistoryId, consumerNumber;
	private double balanceDue;
	private LocalDate LastPaidDate;
	BillHistory bill;

	@BeforeEach
	void setUp()
	{
		billHistoryId = 220L;
		consumerNumber = 210L;
		balanceDue = 100;
		LastPaidDate = LocalDate.now();
		bill = new BillHistory(billHistoryId, consumerNumber, balanceDue, LastPaidDate);

	}

	@Test
	public void viewPaymentHistoryTest()
	{
		when(repo.findBillHistoryByConsumerNumber(consumerNumber)).thenReturn(bill);
		assertEquals(bill,service.viewHistoricalPayment(consumerNumber));
	}
}
*/