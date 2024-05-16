package com.employee.Transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.employee","com.employee.transfer","com.employee.transfer.controller" })
public class EmployeeTransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTransfersApplication.class, args);
	}

}
