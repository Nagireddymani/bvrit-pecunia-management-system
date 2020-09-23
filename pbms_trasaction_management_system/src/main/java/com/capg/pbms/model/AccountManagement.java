package com.capg.pbms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     22-09-2020
-Description              :     AccountManagement Bean Class

*******************************************************************************************************************************/
public class AccountManagement {
	
	private String accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private Double accountBalance;
	private Double accountInterest;
	private LocalDateTime lastUpdated;
	
	
	public AccountManagement() {
	
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public String getAccountBranchId() {
		return accountBranchId;
	}

	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}



	public Double getAccountInterest() {
		return accountInterest;
	}



	public void setAccountInterest(Double accountInterest) {
		this.accountInterest = accountInterest;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "AccountManagement [accountId=" + accountId + ", accountHolderId=" + accountHolderId
				+ ", accountBranchId=" + accountBranchId + ", accountType=" + accountType + ", accountStatus="
				+ accountStatus + ", accountBalance=" + accountBalance + ", accountInterest=" + accountInterest
				+ ", lastUpdated=" + lastUpdated + "]";
	}


	
	
}
