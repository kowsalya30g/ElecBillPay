package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.model.BillHistory;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;
import com.capgemini.services.PaymentServiceImplementation;

@RestController
public class PaymentController {

	@Autowired
	private PaymentServiceImplementation payService;

	@PostMapping("/payBill")
	public ResponseEntity<PaymentStatus> payBill(@RequestBody Payment payment)
	{
		return new ResponseEntity<PaymentStatus>(payService.payBill(payment),HttpStatus.OK);
	}

	@GetMapping("/getLastPaymentHistory/{consumerNumber}")
	public ResponseEntity<BillHistory> getLastPaymentHistory(@PathVariable("consumerNumber") Long consumerNUmber)
	{
		return new ResponseEntity<BillHistory>(payService.viewHistoricalPayment(consumerNUmber),HttpStatus.OK);
	}
}
