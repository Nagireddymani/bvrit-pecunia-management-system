package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Dates;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.service.IPassbookService;

@CrossOrigin
@RestController
@RequestMapping("/passbook")
public class controller {

	@Autowired
	IPassbookService passbookService;

	@GetMapping("/getalltransactions/{accountNum}")
	public List<Transaction> getAllTransactions(@PathVariable String accountNum)
	{
		return passbookService.getAllTransactionsById(accountNum);
	}
	
	@PostMapping("/getalltransaction-btw-dates/{accountNum}")
	public List<Transaction> getAllTransactionsBtwDates(@PathVariable String accountNum, @RequestBody Dates dates)
	{
		return passbookService.getAllTransactionsBetweenDates(dates.getFromDate(),dates.getToDate(), accountNum);
	}
	
	@GetMapping("/getallcheques/{accountNum}")
	public List<Cheque> getAllCheques(@PathVariable String accountNum)
	{
		return passbookService.getAllChequesByAccountNumber(accountNum);
	}

	@GetMapping("/getallslips/{accountNum}")
	public List<Slip> getAllSlips(@PathVariable String accountNum)
	{
		return passbookService.getAllSlipsByAccountNumber(accountNum);
	}
}
