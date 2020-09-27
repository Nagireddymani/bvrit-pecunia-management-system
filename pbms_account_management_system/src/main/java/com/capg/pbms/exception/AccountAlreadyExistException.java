package com.capg.pbms.exception;

public class AccountAlreadyExistException extends RuntimeException{

	public AccountAlreadyExistException (String mesg) {
		super(mesg);
	}
}
