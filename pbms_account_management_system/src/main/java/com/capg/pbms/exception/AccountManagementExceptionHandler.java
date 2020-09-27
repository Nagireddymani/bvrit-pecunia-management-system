package com.capg.pbms.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class AccountManagementExceptionHandler {

	@ExceptionHandler({AccountManagementException.class})
	public ResponseEntity<Object> handleAccountManagementException(){
		return new ResponseEntity<Object>("Error: Invalid Id.",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({AllAccountException.class})
	public ResponseEntity<Object> handleAccountManagementExceptionException(){
		return new ResponseEntity<Object>(" Check the input validations..!!",HttpStatus.BAD_REQUEST);
		
	}
	
	  @ExceptionHandler({OtherExceptions.class}) public
	  ResponseEntity<Object> handleUnknownExceptions(){ return new
	  ResponseEntity<Object>("Something went wrong..!!",HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	/*
	 * @ExceptionHandler({AccountAlreadyExistException.class}) public
	 * ResponseEntity<Object> handleAccountManagementException3(){ return new
	 * ResponseEntity<Object>("Account already exists..!",HttpStatus.CREATED); }
	 */
		 
}
