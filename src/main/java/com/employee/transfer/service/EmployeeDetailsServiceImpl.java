package com.employee.transfer.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.employee.transfer.model.EmployeeDetailsDTO;
import com.employee.transfer.model.EmployeeDetailsEntity;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Value("${getEmployee.details}")
	private String getEmployeesQuery;
	
	
	@Override
	public List<EmployeeDetailsDTO> getEmployeeDetails() throws Exception {
		
		List<EmployeeDetailsDTO> employeeList = new ArrayList<>();
		jdbcTemplate.query(getEmployeesQuery, new ResultSetExtractor<List<EmployeeDetailsDTO>>() {

			@Override
			public List<EmployeeDetailsDTO> extractData(ResultSet empDetails) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
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
}
