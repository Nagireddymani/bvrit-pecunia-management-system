package com.capg.pbms.exception;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     InsufficientBalance Exception 
*******************************************************************************************************************************/
public class InsufficientBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
	
	}
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
	
}
