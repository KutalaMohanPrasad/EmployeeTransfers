package com.employee.transfer.service;

import java.util.List;
import java.util.Set;

import com.employee.transfer.model.EmployeeDetailsDTO;
import com.employee.transfer.model.UpdateUserRequest;
import com.employee.transfer.utils.Status;


public interface EmployeeDetailsService {
		public List<EmployeeDetailsDTO> getEmployeeDetails() throws Exception;

		public Status updateEmployee(UpdateUserRequest request) throws Exception;

		public Status deleteEmployees(Set<Integer> request) throws Exception;

		public Status createEmployee(EmployeeDetailsDTO request) throws Exception;;
}
