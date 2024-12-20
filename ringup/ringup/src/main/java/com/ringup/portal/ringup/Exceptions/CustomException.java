package com.ringup.portal.ringup.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

	 	@ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleProductNotFoundException(ResourceNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
	        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
