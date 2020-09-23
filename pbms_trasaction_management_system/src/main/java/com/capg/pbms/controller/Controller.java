package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.model.TransactionList;
import com.capg.pbms.service.ITransactionService;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Controller Class

*******************************************************************************************************************************/
@RestController
@RequestMapping("/transaction")
public class Controller {
  
	@Autowired
	ITransactionService transactionService;
	
	@PostMapping("/addcheque/{transType}/{toAccountNumber}") 
	public ResponseEntity<Cheque> creditUsingCheque(@RequestBody Cheque cheque, @PathVariable String transType, @PathVariable String toAccountNumber)
	{
		return new ResponseEntity<Cheque>(transactionService.creditUsingCheque(cheque, transType, toAccountNumber), HttpStatus.OK);
	}
	
	@PostMapping("/addcheque/{transType}")
	public ResponseEntity<Cheque> debitUsingCheque(@RequestBody Cheque cheque, @PathVariable String transType)
	{
		return new ResponseEntity<Cheque>(transactionService.debitUsingCheque(cheque, transType), HttpStatus.OK);
	}
	
	@PostMapping("/addslip/{transType}")
	public ResponseEntity<Slip> creditAndDebitUsingSlip(@RequestBody Slip slip,@PathVariable String transType)
	{
		return new ResponseEntity<Slip>(transactionService.creditAndDebitUsingSlip(slip, transType), HttpStatus.OK);
	}
	
	@GetMapping("/getalltransactions")
	public ResponseEntity<List<Transaction>>  getAllTransactions()
	{
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(), HttpStatus.OK);
	}
	
	@GetMapping("/getalltransactions-byaccountnum/{accountNum}")
	public ResponseEntity<TransactionList> getAllTransactionsByAccountNum(@PathVariable String accountNum)
	{
		return  new  ResponseEntity<TransactionList>(new TransactionList(transactionService.getAllTransactionsByAccountNum(accountNum)), HttpStatus.OK);
	}
	
	@GetMapping("/getallcheques")
	public ResponseEntity<List<Cheque>>  getAllCheques()
	{
		return new ResponseEntity<List<Cheque>>(transactionService.getAllCheques(), HttpStatus.OK);
	}	
	
	@GetMapping("/getallcheques-byaccountnum/{accountNum}")
	public ResponseEntity<List<Cheque>>  getAllChequesByAccountNum(@PathVariable String accountNum)
	{
		return new ResponseEntity<List<Cheque>>(transactionService.getAllChequesByAccountNum(accountNum), HttpStatus.OK) ;
	}
	
	@GetMapping("/getallslips")
	public ResponseEntity<List<Slip>> getAllSlips()
	{
		return new ResponseEntity<List<Slip>>(transactionService.getAllSlips(), HttpStatus.OK) ;
	}	
	
	@GetMapping("/getallslips-byaccountnum/{accountNum}")
	public ResponseEntity<List<Slip>> getAllSlipsByAccountNum(@PathVariable String accountNum)
	{
		return  new ResponseEntity<List<Slip>>(transactionService.getAllSlipsByAccountNum(accountNum), HttpStatus.OK);
	}	
}
