package com.capg.pbms.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;

public interface IPassbookService {

	List<Transaction> getAllTransactionsById(String accountId);
	
	List<Transaction> getAllTransactionsBetweenDates(LocalDateTime fromDate, LocalDateTime toDate, String accountId);
	
	List<Cheque> getAllChequesByAccountNumber(String accountNumber);
	
	List<Slip> getAllSlipsByAccountNumber(String accountNumber);
}
