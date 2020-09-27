package com.capg.pbms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class InvalidLoanCrendentialsExceptionHandler extends ResponseEntityExceptionHandler {
/*
	@ExceptionHandler({InvalidLoanCredentialsException.class})
	public ResponseEntity<Object> loanRequestException(){
		return new ResponseEntity<Object>("Invalid Credentials", HttpStatus.NOT_FOUND);
		*/
	

}

