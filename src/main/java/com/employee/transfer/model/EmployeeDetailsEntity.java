package com.employee.transfer.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
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

    // No-args constructor for JPA
    public EmployeeDetailsEntity() {
    }

    // Getters and Setters
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
}
