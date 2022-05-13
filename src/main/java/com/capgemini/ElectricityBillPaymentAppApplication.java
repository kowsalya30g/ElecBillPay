package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ElectricityBillPaymentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillPaymentAppApplication.class, args);
		System.out.println("Running");
	}



}
