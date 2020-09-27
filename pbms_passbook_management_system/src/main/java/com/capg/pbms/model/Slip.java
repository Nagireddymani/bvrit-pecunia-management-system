package com.capg.pbms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*******************************************************************************************************************************
-Author                   :     M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Slip Bean Class

*******************************************************************************************************************************/
@Entity
@Table(name = "slip_table")
public class Slip {

	@Id
    private String slipId;
    private String accountNum;
    private String slipHolderName;
    private String slipType;
    private Double amount;
    private String slipBankName;
    private String bankIFSC;
    private LocalDateTime slipIssueDate;
    
    public Slip() {
	
    }
    

	public Slip(String slipId, String accountNum, String slipHolderName, String slipType, Double amount,
			String slipBankName, String bankIFSC, LocalDateTime slipIssueDate) {
		super();
		this.slipId = slipId;
		this.accountNum = accountNum;
		this.slipHolderName = slipHolderName;
		this.slipType = slipType;
		this.amount = amount;
		this.slipBankName = slipBankName;
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

	public String getSlipBankName() {
		return slipBankName;
	}

	public void setSlipBankName(String slipBankName) {
		this.slipBankName = slipBankName;
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

	

	public String getSlipType() {
		return slipType;
	}


	public void setSlipType(String slipType) {
		this.slipType = slipType;
	}


	@Override
	public String toString() {
		return "Slip [slipId=" + slipId + ", accountNum=" + accountNum + ", slipHolderName=" + slipHolderName
				+ ", slipType=" + slipType + ", amount=" + amount + ", slipBankName=" + slipBankName + ", bankIFSC="
				+ bankIFSC + ", slipIssueDate=" + slipIssueDate + "]";
	}



	
    
    
}
