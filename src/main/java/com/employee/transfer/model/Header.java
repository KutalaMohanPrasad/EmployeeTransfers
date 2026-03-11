package com.employee.transfer.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Header {
	
	public String timestamp;
	
	public String status;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public HttpStatus errorCode;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public String errorMessage;

	// Constructors
	public Header() {
	}

	public Header(String timestamp, String status, HttpStatus errorCode, String errorMessage) {
		this.timestamp = timestamp;
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	// Getters
	public String getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	// Setters
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
