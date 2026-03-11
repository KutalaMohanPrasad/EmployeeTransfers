package com.employee.transfer.model;

public class EmployeeTransferResponse {
	
	public Header header;
	
	public Object response;

	// Constructors
	public EmployeeTransferResponse() {
	}

	public EmployeeTransferResponse(Header header, Object response) {
		this.header = header;
		this.response = response;
	}

	// Getters
	public Header getHeader() {
		return header;
	}

	public Object getResponse() {
		return response;
	}

	// Setters
	public void setHeader(Header header) {
		this.header = header;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
