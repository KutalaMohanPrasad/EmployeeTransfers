package com.employee.transfer.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Header {
	
	public String timestamp;
	
	public String status;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public HttpStatus errorCode;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	public String errorMessage;


}
