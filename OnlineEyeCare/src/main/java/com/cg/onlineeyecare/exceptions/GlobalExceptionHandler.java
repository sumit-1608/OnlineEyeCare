package com.cg.onlineeyecare.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handle specific exception
    @ExceptionHandler(TestIdNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(TestIdNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

	
	  @ExceptionHandler(Exception.class) 
	  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
	  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
	  }
	 
}