package com.employee.transfer.model;

public class UpdateUserRequest {
	
	private int emp_id;
    private String name;
    private String job_name;
    private int manager_id;
    private double salary;
    private double commission;
    private int dep_id;

    // Constructors
    public UpdateUserRequest() {
    }

    public UpdateUserRequest(int emp_id, String name, String job_name, int manager_id, 
                             double salary, double commission, int dep_id) {
        this.emp_id = emp_id;
        this.name = name;
        this.job_name = job_name;
        this.manager_id = manager_id;
        this.salary = salary;
        this.commission = commission;
        this.dep_id = dep_id;
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

    public double getSalary() {
        return salary;
    }

    public double getCommission() {
        return commission;
    }

    public int getDep_id() {
        return dep_id;
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", job_name='" + job_name + '\'' +
                ", manager_id=" + manager_id +
                ", salary=" + salary +
                ", commission=" + commission +
                ", dep_id=" + dep_id +
                '}';
    }
}
