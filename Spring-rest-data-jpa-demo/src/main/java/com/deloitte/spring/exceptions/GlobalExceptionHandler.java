package com.deloitte.spring.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //to make exception class globally
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(IdNotFoundException exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDate.now());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		
	}
	
	/*
	 * @ExceptionHandler(value = IdNotFoundException.class) public
	 * ResponseEntity<Object> handleException(IdNotFoundException exception) {
	 * return new ResponseEntity<Object>(exception.getMessage(),
	 * HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
		ErrorDetails details = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDate.now());
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		
	}

}
