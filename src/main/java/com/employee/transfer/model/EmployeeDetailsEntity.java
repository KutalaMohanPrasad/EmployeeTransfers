package com.employee.transfer.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class EmployeeDetailsEntity {
	@Id
	@Column(name = "emp_id", nullable = false, unique = true)
	private int emp_id;
	@Column(name = "name", nullable = false)
    private String name;
	@Column(name = "job_name", nullable = false)
    private String job_name;
	@Column(name = "manager_id", nullable = false)
    private int manager_id;
	@Column(name = "hire_date", nullable = false)
    private Date hire_date;
	@Column(name = "salary", nullable = false)
    private double salary;
    @Column(name = "commission", nullable = false)
    private double commission;
    @Column(name = "dep_id", nullable = false)
    private int dep_id;

}
