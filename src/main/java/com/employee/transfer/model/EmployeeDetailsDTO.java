package com.employee.transfer.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDetailsDTO {
	
	private int emp_id;
    private String name;
    private String job_name;
    private int manager_id;
    private Date hire_date;
    private double salary;
    private double commission;
    private int dep_id;
    private String location;
    private String department_name;

}
