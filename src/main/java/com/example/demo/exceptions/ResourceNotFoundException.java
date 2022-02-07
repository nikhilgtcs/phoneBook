package com.example.demo.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1l;  
	

	private String errorMsg;
	
	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
