package com.capg.pbms.service;

import java.util.List;
import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Transaction Service Interface

*******************************************************************************************************************************/
public interface ITransactionService {


	Cheque creditUsingCheque(Cheque cheque,String transType,String toAccountNumber);
	
	Cheque debitUsingCheque(Cheque cheque,String transType);
	
	Slip creditAndDebitUsingSlip(Slip slip, String transType);
	
	List<Transaction> getAllTransactions();
	
	List<Transaction> getAllTransactionsByAccountNum(String accountNum);
	
	List<Cheque> getAllCheques();
	
	List<Cheque> getAllChequesByAccountNum(String accountNum);
	
    List<Slip> getAllSlips();
	
	List<Slip> getAllSlipsByAccountNum(String accountNum);
	
}
