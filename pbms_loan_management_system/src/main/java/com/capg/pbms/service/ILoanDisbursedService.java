package com.capg.pbms.service;

import java.util.List;

import com.capg.pbms.model.LoanDisburseb;

public interface ILoanDisbursedService {

	LoanDisburseb addLoanDisburseb(LoanDisburseb loanDisburseb);
	
	List<LoanDisburseb> getAllLoanDisburses();

	List<LoanDisburseb> getAllLoanDisbursesByLoanRequestId(String LoanRequestId);
}
