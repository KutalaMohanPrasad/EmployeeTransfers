package com.employee.transfer.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.transfer.model.EmployeeDetailsDTO;
import com.employee.transfer.model.EmployeeTransferResponse;
import com.employee.transfer.model.Header;
import com.employee.transfer.model.UpdateUserRequest;
import com.employee.transfer.service.EmployeeDetailsService;
import com.employee.transfer.utils.Status;

@RestController
@RequestMapping("/api/v1")
public class EmployeeDetailsController {


	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@GetMapping("/getAllEmployeeDetails")
	public ResponseEntity<EmployeeTransferResponse> getEmployeeDetails() throws Exception {
		List<EmployeeDetailsDTO> employeeList= employeeDetailsService.getEmployeeDetails();
		Header header = Header.builder().timestamp(new Date().toString()).status("SUCCESS").build();
		EmployeeTransferResponse response = EmployeeTransferResponse.builder().header(header).response(employeeList).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/updateEmployee")
	public ResponseEntity<EmployeeTransferResponse> updateEmployeeDetails(@RequestBody UpdateUserRequest request) throws Exception{
		Status status =null;
		if(request ==null) {
			status = Status.FAILURE;
		} else {
			status = employeeDetailsService.updateEmployee(request);
		}
		Header header = Header.builder().timestamp(new Date().toString()).status("SUCCESS").build();
		EmployeeTransferResponse response = EmployeeTransferResponse.builder().header(header).response(status).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/deleteEmployees")
	public ResponseEntity<EmployeeTransferResponse> deleteEmployees(@RequestBody Set<Integer> request) throws Exception{
		Status status =null;
		if(request == null || request.size() ==0) {
			status = Status.FAILURE;
		} else {
			status = employeeDetailsService.deleteEmployees(request);
		}
		Header header = Header.builder().timestamp(new Date().toString()).status("SUCCESS").build();
		EmployeeTransferResponse response = EmployeeTransferResponse.builder().header(header).response(status).build();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


}