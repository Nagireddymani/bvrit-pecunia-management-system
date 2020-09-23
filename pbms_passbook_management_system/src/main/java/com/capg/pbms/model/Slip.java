package com.capg.pbms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slip {

	@Id
    private String slipId;
    private String accountNum;
    private String slipHolderName;
    private Double amount;
    private String chequeBankName;
    private String bankIFSC;
    private LocalDateTime slipIssueDate;
    
    public Slip() {
	
    }

	public Slip(String slipId, String accountNum, String slipHolderName, Double amount, String chequeBankName,
			String bankIFSC, LocalDateTime slipIssueDate) {
		super();
		this.slipId = slipId;
		this.accountNum = accountNum;
		this.slipHolderName = slipHolderName;
		this.amount = amount;
		this.chequeBankName = chequeBankName;
		this.bankIFSC = bankIFSC;
		this.slipIssueDate = slipIssueDate;
	}




	public String getSlipId() {
		return slipId;
	}

	public void setSlipId(String slipId) {
		this.slipId = slipId;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getSlipHolderName() {
		return slipHolderName;
	}

	public void setSlipHolderName(String slipHolderName) {
		this.slipHolderName = slipHolderName;
	}

	public String getChequeBankName() {
		return chequeBankName;
	}

	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}

	public String getBankIFSC() {
		return bankIFSC;
	}

	public void setBankIFSC(String bankIFSC) {
		this.bankIFSC = bankIFSC;
	}

	public LocalDateTime getSlipIssueDate() {
		return slipIssueDate;
	}

	public void setSlipIssueDate(LocalDateTime slipIssueDate) {
		this.slipIssueDate = slipIssueDate;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Slip [slipId=" + slipId + ", accountNum=" + accountNum + ", slipHolderName=" + slipHolderName
				+ ", amount=" + amount + ", chequeBankName=" + chequeBankName + ", bankIFSC=" + bankIFSC
				+ ", slipIssueDate=" + slipIssueDate + "]";
	}

	
    
    
}
