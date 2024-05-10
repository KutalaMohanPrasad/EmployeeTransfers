package com.employee.transfer.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.employee.transfer.model.EmployeeDetailsDTO;
import com.employee.transfer.model.UpdateUserRequest;
import com.employee.transfer.utils.Status;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Value("${getEmployee.details}")
	private String getEmployeesQuery;
	
	@Value("${update.Employee}")
	private String updateEmployeeQuery;
	
	@Value("${delete.Employees}")
	private String deleteEmployeesQuery;
	
	
	@Override
	public List<EmployeeDetailsDTO> getEmployeeDetails() throws Exception {
		
		List<EmployeeDetailsDTO> employeeList = new ArrayList<>();
		jdbcTemplate.query(getEmployeesQuery, new ResultSetExtractor<List<EmployeeDetailsDTO>>() {

			@Override
			public List<EmployeeDetailsDTO> extractData(ResultSet empDetails) throws SQLException, DataAccessException {
				while(empDetails.next()) {
					EmployeeDetailsDTO employee = new EmployeeDetailsDTO();
					employee.setEmp_id(empDetails.getInt("emp_id"));
					employee.setDep_id(empDetails.getInt("dep_id"));
					employee.setCommission(empDetails.getDouble("commission"));
					employee.setHire_date(empDetails.getDate("hire_date"));
					employee.setJob_name(empDetails.getString("job_name"));
					employee.setManager_id(empDetails.getInt("manager_id"));
					employee.setName(empDetails.getString("name"));
					employee.setSalary(empDetails.getDouble("salary"));
					employee.setDepartment_name(empDetails.getString("dname"));
					employee.setLocation(empDetails.getString("loc"));
					employeeList.add(employee);
				}
				return null;
			}
			
		});
		return employeeList;
	}

	@Override
	public Status updateEmployee(UpdateUserRequest request) throws Exception {
		
		int rowsUpdate = jdbcTemplate.update(updateEmployeeQuery, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, request.getName());
				ps.setString(2, request.getJob_name());
				ps.setInt(3, request.getManager_id());
				ps.setDouble(4, request.getSalary());
				ps.setDouble(5, request.getCommission());
				ps.setInt(6, request.getDep_id());
				ps.setInt(7, request.getEmp_id());
				
			}
			
		});
		return (rowsUpdate > 0) ? Status.SUCCESS : Status.FAILURE;
	}

	@Override
	public Status deleteEmployees(Set<Integer> request) throws Exception {
		List<Integer> requestList = new ArrayList<>(request);
		int[] rowsDeleted = jdbcTemplate.batchUpdate(deleteEmployeesQuery, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, requestList.get(i));
				
			}
			
			@Override
			public int getBatchSize() {
				return request.size();
			}
		});
		return getBatchUpdateStatus(rowsDeleted);
	}

	private Status getBatchUpdateStatus(int[] rowsDeleted) {
		for(int i: rowsDeleted) {
			if(i<0)
				return Status.FAILURE;
		}
		return Status.SUCCESS;
	}
}
