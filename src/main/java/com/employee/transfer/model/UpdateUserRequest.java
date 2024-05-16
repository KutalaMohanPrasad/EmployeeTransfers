package com.employee.transfer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateUserRequest {
	
	private int emp_id;
    private String name;
    private String job_name;
    private int manager_id;
    private double salary;
    private double commission;
    private int dep_id;

}
