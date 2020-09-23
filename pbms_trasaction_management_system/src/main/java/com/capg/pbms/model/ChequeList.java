package com.capg.pbms.model;

import java.util.List;

public class ChequeList {

	private List<Cheque> chequeList;
	
	public ChequeList() {
		// TODO Auto-generated constructor stub
	}

	public ChequeList(List<Cheque> chequeList) {
		super();
		this.chequeList = chequeList;
	}

	public List<Cheque> getChequeList() {
		return chequeList;
	}

	public void setChequeList(List<Cheque> chequeList) {
		this.chequeList = chequeList;
	}

	@Override
	public String toString() {
		return "ChequeList [chequeList=" + chequeList + "]";
	}
	
	
}
