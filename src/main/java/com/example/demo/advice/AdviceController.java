package com.example.demo.advice;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exceptions.ErrorDetails;
import com.example.demo.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> noResourceExists(ResourceNotFoundException resourceNotFoundException, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFoundException.getErrorMsg(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		
	}
	
	
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> noSuchElementExists(NoSuchElementException noSuchElementException){
//		
//		return new ResponseEntity<String>("No Contact with given id exists", HttpStatus.BAD_REQUEST);
//		
//	}
	

}
