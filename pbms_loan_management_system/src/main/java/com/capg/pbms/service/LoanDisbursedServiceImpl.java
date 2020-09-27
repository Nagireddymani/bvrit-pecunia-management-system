package com.capg.pbms.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.exception.InvalidLoanCredentialsException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.LoanDisburseb;
import com.capg.pbms.model.LoanRequest;
import com.capg.pbms.repository.ILoanDisbursedRepository;
import com.capg.pbms.repository.ILoanRequestRepository;

@Service
public class LoanDisbursedServiceImpl implements ILoanDisbursedService {

	@Autowired
	ILoanDisbursedRepository loanDisbursedRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ILoanRequestRepository loanRequestRepository;

	@Autowired
	Random random;

	@Override
	public LoanDisburseb addLoanDisburseb(LoanDisburseb loanDisburseb) {
		
		LoanRequest loanRequest = loanRequestRepository.getOne(loanDisburseb.getLoanRequestId());
		if(loanRequest==null)
		{
			 throw new InvalidLoanCredentialsException("Invalid Loan ID Number");
		}
		AccountManagement account= 	restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+loanDisburseb.getLoanAccountNum(), AccountManagement.class);
		
		if(account==null)
		{
			 throw new InvalidLoanCredentialsException("Invalid Account Number");
		}
		
		Double balance = loanRequest.getLoanAmount() - loanDisburseb.getLoanAmountPaid();
		
		
		
		loanRequest.setLoanAmount(balance);
		
		loanDisburseb.setLoanDisbursedId(Integer.toString(random.nextInt(1000000)).substring(0, 4));
		
		loanDisburseb.setLoanDueDate(loanRequest.getLoanIssueDate().plusMonths(loanRequest.getLoanEmi()));
		
		loanRequestRepository.save(loanRequest);
		
		return loanDisbursedRepository.save(loanDisburseb);
	}

	

	@Override
	public List<LoanDisburseb> getAllLoanDisburses() {
		return loanDisbursedRepository.findAll();
	}

	@Override
	public List<LoanDisburseb> getAllLoanDisbursesByLoanRequestId(String loanRequestId) {
		return loanDisbursedRepository.findByLoanRequestId(loanRequestId);
	}

}
