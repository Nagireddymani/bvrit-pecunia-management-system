package com.capg.pbms.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.pbms.exception.InvalidLoanCredentialsException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.LoanRequest;
import com.capg.pbms.repository.ILoanRequestRepository;

@Service
public class LoanRequestServiceImpl implements ILoanRequestService {

	@Autowired
	ILoanRequestRepository loanRequestRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Random random;
	
	@Override
	public LoanRequest addLoanRequest(LoanRequest loanRequest) {
		AccountManagement account= 	restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+loanRequest.getLoanAccountNum(), AccountManagement.class);
		
		if(account== null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		loanRequest.setLoanRequestId(Integer.toString(random.nextInt(1000000)).substring(0,4));
		
		if(loanRequest.getLoanAccountNum().length()!=15) {
			throw new InvalidLoanCredentialsException("Invalid Account Number");
			}
		if(!(loanRequest.getLoanAmount()>100000 && loanRequest.getLoanAmount()<10000000)) {
			throw new InvalidLoanCredentialsException("Invalid Amount");
		}
		if(!(loanRequest.getLoanRoi()>4 && loanRequest.getLoanRoi()<15)) {
			throw new InvalidLoanCredentialsException("Invalid Rate of Interest");
		}
		if(!(loanRequest.getLoanEmi()>12 && loanRequest.getLoanEmi()<240)) {
			throw new InvalidLoanCredentialsException("Invalid EMI Tenure ");
		}
		loanRequest.setLoanIssueDate(LocalDateTime.now());
		return loanRequestRepository.save(loanRequest);
	}

	@Override
	public LoanRequest acceptRequest(String loanRequestId, boolean status) throws RestClientException, URISyntaxException {
		LoanRequest loanRequest = loanRequestRepository.getOne(loanRequestId);
		loanRequest.setLoanStatus("Active");
		
		AccountManagement account= 	restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+loanRequest.getLoanAccountNum(), AccountManagement.class);
		
		account.setAccountBalance(account.getAccountBalance()+loanRequest.getLoanAmount());
		account.setLastUpdated(LocalDateTime.now());
		loanRequestRepository.save(loanRequest);
		
		restTemplate.put(new URI("http://localhost:8200/customer/updateaccount"), account);

		return loanRequest;
	}


	@Override
	public List<LoanRequest> getAllLoanReqest() {
		
		return loanRequestRepository.findAll();
	}

	

}
