/*package com.capgemini.tests;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.model.Bill;
import com.capgemini.model.Connection;
import com.capgemini.model.Reading;
import com.capgemini.repository.ConnectionRepository;
import com.capgemini.repository.ReadingRepository;
import com.capgemini.services.ReadingServiceImplementation;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class ReadingServiceImplementationTest{

	private Reading reading;
	private Connection connection;

	@Autowired
	private ReadingServiceImplementation readingService;

	@MockBean
	private ReadingRepository readingRepo;

	@MockBean
	private ConnectionRepository connectionRepo;

	@BeforeEach
	void setUp() throws Exception {
		connection = new Connection();
		connection.setConsumerNumber((long) 9);

		reading = new Reading();
		reading.setConsumerNumber((long) 9);
		reading.setReadingDate(LocalDate.now());
		reading.setReadingId((long) 15);
		reading.setUnitsConsumed(100);
		reading.setReadingPhoto("image1.jpg");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindMeterReadingByConsumerNumberAndBillDate() {
		Bill bill = new Bill();
		bill.setBillDate(LocalDate.of(2022, 3, 10));
		Mockito.when(readingRepo.findReadingByConsumerNumberAndBillDate((long) 9, LocalDate.of(2022, 3, 10))).thenReturn(reading);
		Mockito.when(connectionRepo.findByConsumerNumber((long) 9)).thenReturn(connection);
		assertThat(readingService.findMeterReadingByConsumerNumberAndBillDate((long) 9, LocalDate.of(2022, 3, 10))).isEqualTo(reading);

	}

	@Test
	void testFindMeterReadingByConsumerNumber() {
		List<Reading> readingList = new ArrayList<>();
		readingList.add(reading);
		Mockito.when(readingRepo.findReadingByConsumerNumber((long) 9)).thenReturn(readingList);
		Mockito.when(connectionRepo.findByConsumerNumber((long) 9)).thenReturn(connection);
		assertThat(readingService.findMeterReadingByConsumerNumber((long) 9)).isEqualTo(readingList);
	}

}

*/