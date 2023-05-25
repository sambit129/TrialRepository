package com.sambit.customerdatamanagement.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sambit.customerdatamanagement.dto.ResponseStructure;

@ControllerAdvice
//@RestControllerAdvice --> 2 taa jaka chaliba
public class ExceptionHandlerUtil {
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noNoDataFoundException(NoDataFoundException ie){
   ResponseStructure<String> responseStructure=new ResponseStructure<String>();
	responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
	responseStructure.setMessage("No data found");
	responseStructure.setData(ie.getMessage());
	responseStructure.setTimeStamp(LocalDateTime.now());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
}

}
