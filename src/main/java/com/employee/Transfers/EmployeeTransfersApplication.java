package com.employee.Transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = { "com.employee.transfer"})
public class EmployeeTransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTransfersApplication.class, args);
	}

}
