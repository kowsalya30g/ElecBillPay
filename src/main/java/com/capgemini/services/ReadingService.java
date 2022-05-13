package com.capgemini.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.model.Reading;

@Service
public interface ReadingService {

	public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate) throws NoSuchCustomerException;
	public List<Reading> findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException;
	public ResponseEntity<Object> selfSubmitReading(Long consumerNumber, int unitsConsumed,LocalDate readingDate, MultipartFile multipartFile) throws IOException;

}