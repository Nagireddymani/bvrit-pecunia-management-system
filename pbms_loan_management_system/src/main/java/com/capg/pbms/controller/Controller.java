package com.capg.pbms.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.pbms.model.LoanDisburseb;
import com.capg.pbms.model.LoanRequest;
import com.capg.pbms.service.ILoanDisbursedService;
import com.capg.pbms.service.ILoanRequestService;

@CrossOrigin
@RestController
@RequestMapping("/loan")
public class Controller {

	@Autowired
	ILoanRequestService loanRequestService;
	
	@Autowired
	ILoanDisbursedService loanDisbursedService;
	
	/***************************************************************************************************************
	 * -FunctionName : Add loan Request
	
	 * -Description :This method is used to add a loan request to the system
	 ***************************************************************************************************************/
	
	@PostMapping("/addloanrequest")
	public LoanRequest addLoanRequest(@RequestBody LoanRequest loanRequest) 
	{
		return loanRequestService.addLoanRequest(loanRequest);
	}
	
	/***************************************************************************************************************
	 * -FunctionName : AcceptLoanRequest
	
	 * -Description :In this we will accept the loan requests which we have got 
	 ***************************************************************************************************************/
	@PutMapping("/acceptloanrequest/{loanRequestId}/{status}")
	public LoanRequest acceptLoanRequest(@PathVariable String loanRequestId, boolean status)throws RestClientException, URISyntaxException
	{
		return loanRequestService.acceptRequest(loanRequestId, status);
	}
	
	/***************************************************************************************************************
	 * -FunctionName : Get All Loans
	
	 * -Description :In this we get all loans requests which has been added to the system
	 ***************************************************************************************************************/
	
	@GetMapping("/getallloans")
	public List<LoanRequest> getAllLoans(){
		return loanRequestService.getAllLoanReqest();
	}
	
	
	/***************************************************************************************************************
	 * -FunctionName : Add Loan Disbursed
	
	 * -Description :In this we will pay the some amount in loan which we have got
	 ***************************************************************************************************************/
	@PostMapping("/addloandisbursed")
	public LoanDisburseb addLoanDisbursed(@RequestBody LoanDisburseb loanDisburseb) 
	{
		return loanDisbursedService.addLoanDisburseb(loanDisburseb);
	}
	
	
	/***************************************************************************************************************
	 * -FunctionName : Get All Loan Disbursed
	
	 * -Description :In this we will get all loan payments done by the customer 
	 ***************************************************************************************************************/
	@GetMapping("/getallloandisburses")
	public List<LoanDisburseb> getAllLoanDisbursed(){
		return loanDisbursedService.getAllLoanDisburses();
	}

	
	/***************************************************************************************************************
	 * -FunctionName : Get All LoanDisbursedByLoanRequestId
	
	 * -Description :In this we get the loan payments by request Id 
	 ***************************************************************************************************************/
	@GetMapping("/getalloandisburses-bylaonrequestid/{loanRequestId}")
	public List<LoanDisburseb> getAllLoanDisbursedByLoanRequestId(@PathVariable String loanRequestId )
	{
		return loanDisbursedService.getAllLoanDisbursesByLoanRequestId(loanRequestId);
	}
}
