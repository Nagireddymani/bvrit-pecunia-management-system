package com.capg.pbms.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     22-09-2020
-Description              :     Cheque Bean Class

*******************************************************************************************************************************/
@Entity
@Table(name = "cheque_table")
public class Cheque {

	@Id
    private String chequeId;
    private Integer chequeNum;
    private String accountNum;
    private Double amount;
    private String chequeHolderName;
    private String chequeBankName;
    private String chequeIFSC;
    private LocalDateTime chequeIssueDate;
    private String chequeStatus;
    
    public Cheque() {
	
	}

   
	public Cheque(String chequeId, Integer chequeNum, String accountNum, Double amount, String chequeHolderName,
			String chequeBankName, String chequeIFSC, LocalDateTime chequeIssueDate, String chequeStatus) {
		super();
		this.chequeId = chequeId;
		this.chequeNum = chequeNum;
		this.accountNum = accountNum;
		this.amount = amount;
		this.chequeHolderName = chequeHolderName;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeStatus = chequeStatus;
	}


	public String getChequeId() {
		return chequeId;
	}


	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}


	public Integer getChequeNum() {
		return chequeNum;
	}


	public void setChequeNum(Integer chequeNum) {
		this.chequeNum = chequeNum;
	}


	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getChequeHolderName() {
		return chequeHolderName;
	}


	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}


	public String getChequeBankName() {
		return chequeBankName;
	}


	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}


	public String getChequeIFSC() {
		return chequeIFSC;
	}


	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}


	public LocalDateTime getChequeIssueDate() {
		return chequeIssueDate;
	}


	public void setChequeIssueDate(LocalDateTime chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}


	public String getChequeStatus() {
		return chequeStatus;
	}


	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}


	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeNum=" + chequeNum + ", accountNum=" + accountNum + ", amount="
				+ amount + ", chequeHolderName=" + chequeHolderName + ", chequeBankName=" + chequeBankName
				+ ", chequeIFSC=" + chequeIFSC + ", chequeIssueDate=" + chequeIssueDate + ", chequeStatus="
				+ chequeStatus + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNum == null) ? 0 : accountNum.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((chequeBankName == null) ? 0 : chequeBankName.hashCode());
		result = prime * result + ((chequeHolderName == null) ? 0 : chequeHolderName.hashCode());
		result = prime * result + ((chequeIFSC == null) ? 0 : chequeIFSC.hashCode());
		result = prime * result + ((chequeId == null) ? 0 : chequeId.hashCode());
		result = prime * result + ((chequeIssueDate == null) ? 0 : chequeIssueDate.hashCode());
		result = prime * result + ((chequeNum == null) ? 0 : chequeNum.hashCode());
		result = prime * result + ((chequeStatus == null) ? 0 : chequeStatus.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cheque other = (Cheque) obj;
		if (accountNum == null) {
			if (other.accountNum != null)
				return false;
		} else if (!accountNum.equals(other.accountNum))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (chequeBankName == null) {
			if (other.chequeBankName != null)
				return false;
		} else if (!chequeBankName.equals(other.chequeBankName))
			return false;
		if (chequeHolderName == null) {
			if (other.chequeHolderName != null)
				return false;
		} else if (!chequeHolderName.equals(other.chequeHolderName))
			return false;
		if (chequeIFSC == null) {
			if (other.chequeIFSC != null)
				return false;
		} else if (!chequeIFSC.equals(other.chequeIFSC))
			return false;
		if (chequeId == null) {
			if (other.chequeId != null)
				return false;
		} else if (!chequeId.equals(other.chequeId))
			return false;
		if (chequeIssueDate == null) {
			if (other.chequeIssueDate != null)
				return false;
		} else if (!chequeIssueDate.equals(other.chequeIssueDate))
			return false;
		if (chequeNum == null) {
			if (other.chequeNum != null)
				return false;
		} else if (!chequeNum.equals(other.chequeNum))
			return false;
		if (chequeStatus == null) {
			if (other.chequeStatus != null)
				return false;
		} else if (!chequeStatus.equals(other.chequeStatus))
			return false;
		return true;
	}
	
	
   
    
}
