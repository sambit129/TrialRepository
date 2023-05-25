package com.sambit.customerdatamanagement.exceptionHandler;

public class NoDataFoundException extends RuntimeException {

	public String message="No data found for the given request";
	
	public NoDataFoundException() {
		
		
	}
	public NoDataFoundException(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
