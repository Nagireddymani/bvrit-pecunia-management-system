package com.capg.pbms.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     TransactionList Bean Class

*******************************************************************************************************************************/
public class TransactionList {

	private List<Transaction> transactions;
	
	public TransactionList() {
	
	}

	public TransactionList(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "TransactionList [transactions=" + transactions + "]";
	}
	
	
}
