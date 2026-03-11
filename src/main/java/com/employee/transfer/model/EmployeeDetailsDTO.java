package com.employee.transfer.model;

import java.sql.Date;

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

    // Constructors
    public EmployeeDetailsDTO() {
    }

    public EmployeeDetailsDTO(int emp_id, String name, String job_name, int manager_id, Date hire_date, 
                              double salary, double commission, int dep_id, String location, String department_name) {
        this.emp_id = emp_id;
        this.name = name;
        this.job_name = job_name;
        this.manager_id = manager_id;
        this.hire_date = hire_date;
        this.salary = salary;
        this.commission = commission;
        this.dep_id = dep_id;
        this.location = location;
        this.department_name = department_name;
    }

    // Getters
    public int getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public String getJob_name() {
        return job_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public double getCommission() {
        return commission;
    }

    public int getDep_id() {
        return dep_id;
    }

    public String getLocation() {
        return location;
    }

    public String getDepartment_name() {
        return department_name;
    }

    // Setters
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "EmployeeDetailsDTO{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", job_name='" + job_name + '\'' +
                ", manager_id=" + manager_id +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                ", commission=" + commission +
                ", dep_id=" + dep_id +
                ", location='" + location + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
