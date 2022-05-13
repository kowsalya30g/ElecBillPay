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
import com.capgemini.model.Bill;
import com.capgemini.model.Reading;
import com.capgemini.repository.BillRepository;
import com.capgemini.services.BillServiceImplementation;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BillServiceImplementationTest {

	@MockBean
	private BillRepository repo;

	@Autowired
	private BillServiceImplementation service;

	Long billId, readingId, consumerNumber;
	LocalDate billDate, billDueDate, readingDate ;
	String readingPhoto, ans;
	int unitsConsumed;
	double billAmount;
	Reading reading;
	Bill bill;

	@BeforeEach
	void setUp()
	{
		consumerNumber = 205L;
		billId = 220L;
		readingId = 210L;
		billDate = readingDate =LocalDate.now();
		billDueDate = billDate.withDayOfMonth(billDate.getMonth().length(billDate.isLeapYear()));
		unitsConsumed = 100;
		billAmount = 340;

		reading = new Reading(readingId, consumerNumber, unitsConsumed, readingPhoto, readingDate );
		bill = new Bill(billId, reading, billDate, billDueDate, unitsConsumed, billAmount);
		ans= bill.toString();

	}

	@Test
	public void viewBillByConsumerNumberTest()
	{
		when(repo.findBillByConsumerNumber(consumerNumber)).thenReturn(bill);
		assertEquals(ans,service.viewBillByConsumerNumber(consumerNumber).toString());

	}

}
*/