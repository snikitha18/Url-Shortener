package com.springboot.UrlShortner.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	 @ExceptionHandler(UrlNotFoundException.class)
	    public ResponseEntity<String> handleUrlNotFoundException(UrlNotFoundException ex) {
	        logger.error("Exception Handled: {}", ex.getMessage());
	        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGlobalException(Exception ex) {
	        logger.error("Unexpected Error Occurred: {}", ex.getMessage(), ex);
	        return new ResponseEntity<>("Something went wrong. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
