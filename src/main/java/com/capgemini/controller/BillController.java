package com.capgemini.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.capgemini.model.Bill;
import com.capgemini.services.BillServiceImplementation;

@RestController
public class BillController {
	
	@Autowired
	private BillServiceImplementation billService;

	@RequestMapping(value = "/createBill", method = RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String createBill(@RequestParam("consumerNumber") Long consumerNumber,@RequestParam("unitsConsumed") int unitsConsumed,
			@RequestParam("readingPhoto") MultipartFile multipartFile) throws IOException {

		return billService.createBill(consumerNumber,unitsConsumed,multipartFile);
	}

	@GetMapping("/viewBillByConsumerNumber/{consumerNumber}")
	public Bill viewBillByConsumerNumber(@PathVariable("consumerNumber") Long consumerNumber)
	{
		return billService.viewBillByConsumerNumber(consumerNumber);
	}

	@GetMapping("/emailBillToCustomer/{consumerNumber}/{email}")
	public String emailBillToCustomer(@PathVariable("consumerNumber") Long consumerNumber,@PathVariable("email") String email)
	{
		return billService.emailBillToCustomer(consumerNumber,email);
	}

}
