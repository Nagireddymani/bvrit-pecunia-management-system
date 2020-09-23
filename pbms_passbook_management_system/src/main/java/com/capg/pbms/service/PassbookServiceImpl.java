package com.capg.pbms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.exception.InvalidAccountNumberException;
import com.capg.pbms.exception.InvalidDatesException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.ChequeList;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.SlipList;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.model.TransactionList;

@Service
public class PassbookServiceImpl implements IPassbookService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Transaction> getAllTransactionsById(String accountNum) {
		
	    AccountManagement account = restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+accountNum, AccountManagement.class);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		
		TransactionList transactionList = restTemplate.getForObject("http://localhost:8300/transaction/getalltransactions-byaccountnum/"+accountNum, TransactionList.class);
	    
		return transactionList.getTransactions();
	}

	@Override
	public List<Transaction> getAllTransactionsBetweenDates(LocalDateTime fromDate, LocalDateTime toDate,
			String accountNum) {

	    AccountManagement account = restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+accountNum, AccountManagement.class);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		if(fromDate.isAfter(toDate))
		{
			throw new InvalidDatesException();
		}
		
		TransactionList transactionList = restTemplate.getForObject("http://localhost:8300/transaction/getalltransactions-byaccountnum/"+accountNum, TransactionList.class);
		
		List<Transaction> transactions=new ArrayList<Transaction>();
		
		for(Transaction transaction : transactionList.getTransactions())
		{
			LocalDateTime date=transaction.getTransDate();
			if(date.isAfter(fromDate) && date.isBefore(toDate))
			{
				transactions.add(transaction);
			}
		}
		return transactions;
	}

	@Override
	public List<Cheque> getAllChequesByAccountNumber(String accountNumber) {
		AccountManagement account = restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+accountNumber, AccountManagement.class);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		ChequeList chequeList=restTemplate.getForObject("http://localhost:8300/transaction/getallcheques-byaccountnum/"+accountNumber, ChequeList.class);
		return chequeList.getChequeList();
	}

	@Override
	public List<Slip> getAllSlipsByAccountNumber(String accountNumber) {
		AccountManagement account = restTemplate.getForObject("http://localhost:8200/customer/getaccount/"+accountNumber, AccountManagement.class);
		if(account==null)
		{
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		SlipList slipList=restTemplate.getForObject("http://localhost:8300/transaction/getallslips-byaccountnum/"+accountNumber, SlipList.class);
		return slipList.getSlipList();
	}

}
