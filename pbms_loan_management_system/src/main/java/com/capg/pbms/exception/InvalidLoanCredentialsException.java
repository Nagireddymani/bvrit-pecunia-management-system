package com.capg.pbms.exception;

public class InvalidLoanCredentialsException extends RuntimeException{
	
	public InvalidLoanCredentialsException() {


	}
	public InvalidLoanCredentialsException(String msg) {

		super(msg);
	}
}
