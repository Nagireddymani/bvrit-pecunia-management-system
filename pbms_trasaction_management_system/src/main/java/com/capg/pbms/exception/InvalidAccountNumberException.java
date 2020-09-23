package com.capg.pbms.exception;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     InvalidAccountNumberException 
*******************************************************************************************************************************/
public class InvalidAccountNumberException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccountNumberException() {

	}
	
	public InvalidAccountNumberException(String message) {
		super(message);
	}
}
