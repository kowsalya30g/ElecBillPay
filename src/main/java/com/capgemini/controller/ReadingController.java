package com.capgemini.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.capgemini.services.ReadingServiceImplementation;

@RestController
public class ReadingController {

	@Autowired
	private ReadingServiceImplementation readingService;

	@RequestMapping(value = "/selfSubmitReading", method = RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> selfSubmitReading(@RequestParam("consumerNumber") Long consumerNumber,@RequestParam("unitsConsumed") int unitsConsumed,
			@RequestParam("readingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate readingDate,@RequestParam("readingPhoto") MultipartFile multipartFile) throws IOException {

		return readingService.selfSubmitReading(consumerNumber,unitsConsumed,readingDate,multipartFile);
	}

	@GetMapping("/findMeterReadingByConsumerNumber/{consumerNumber}")
	public ResponseEntity<Object> findMeterReadingByConsumerNumber(@PathVariable("consumerNumber") Long consumerNumber){
		return new ResponseEntity<Object>(readingService.findMeterReadingByConsumerNumber(consumerNumber),HttpStatus.OK);
	}

	@GetMapping("/findMeterReadingByConsumerNumberAndBillDate/{consumerNumber}/{billDate}")
	public ResponseEntity<Object> findMeterReadingByConsumerNumberAndBillDate(@PathVariable("consumerNumber") Long consumerNumber,@RequestParam("billDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate billDate){
		return new ResponseEntity<Object>(readingService.findMeterReadingByConsumerNumberAndBillDate(consumerNumber,billDate),HttpStatus.OK);
	}

}