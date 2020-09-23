package com.capg.pbms.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.exception.InsufficientBalanceException;
import com.capg.pbms.exception.InvalidAccountNumberException;
import com.capg.pbms.model.ErrorResponse;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     ErrorController Class for Handling Exceptions

*******************************************************************************************************************************/
@RestController
@ControllerAdvice
public class ErrorController {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidAccountNumberException.class)
	public ErrorResponse handleInvalidAccountNumberException(Exception ex,HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), req.getRequestURI());
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InsufficientBalanceException.class)
	public ErrorResponse handleInSufficientAmountException(Exception ex,HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value(), req.getRequestURI());
	}
}
