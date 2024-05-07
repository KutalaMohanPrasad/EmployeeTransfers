package com.employee.transfer.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmployeeTransferResponse {
	
	public Header header;
	
	public Object response;
}
