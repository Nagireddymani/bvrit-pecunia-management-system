package com.capg.pbms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Transaction Bean Class

*******************************************************************************************************************************/
@Entity
@Table(name = "transaction_table")
public class Transaction {
	
	@Id
	private String transId;
	private String transAccountId;
	private String transType;
	private Double transAmount;
	private String transOption;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime transDate;
	private String transFrom;
	private String transTo;
	private Double transClosingBalnace;
	
	public Transaction() {
	
	}

	public Transaction(String transId, String transAccountId, String transType, Double transAmount, String transOption,
			LocalDateTime transDate, String transFrom, String transTo, Double transClosingBalnace) {
		super();
		this.transId = transId;
		this.transAccountId = transAccountId;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transOption = transOption;
		this.transDate = transDate;
		this.transFrom = transFrom;
		this.transTo = transTo;
		this.transClosingBalnace = transClosingBalnace;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransAccountId() {
		return transAccountId;
	}

	public void setTransAccountId(String transAccountId) {
		this.transAccountId = transAccountId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getTransAmount() {
		return transAmount;
	}


	public void setTransAmount(Double transAmount) {
		this.transAmount = transAmount;
	}


	public String getTransOption() {
		return transOption;
	}

	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}

	public LocalDateTime getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDateTime transDate) {
		this.transDate = transDate;
	}

	public String getTransFrom() {
		return transFrom;
	}

	public void setTransFrom(String transFrom) {
		this.transFrom = transFrom;
	}

	public String getTransTo() {
		return transTo;
	}

	public void setTransTo(String transTo) {
		this.transTo = transTo;
	}

	public Double getTransClosingBalnace() {
		return transClosingBalnace;
	}

	public void setTransClosingBalnace(Double transClosingBalnace) {
		this.transClosingBalnace = transClosingBalnace;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transAccountId=" + transAccountId + ", transType=" + transType
				+ ", transAmount=" + transAmount + ", transOption=" + transOption + ", transDate=" + transDate
				+ ", transFrom=" + transFrom + ", transTo=" + transTo + ", transClosingBalnace=" + transClosingBalnace
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transAccountId == null) ? 0 : transAccountId.hashCode());
		result = prime * result + ((transAmount == null) ? 0 : transAmount.hashCode());
		result = prime * result + ((transClosingBalnace == null) ? 0 : transClosingBalnace.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + ((transFrom == null) ? 0 : transFrom.hashCode());
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		result = prime * result + ((transOption == null) ? 0 : transOption.hashCode());
		result = prime * result + ((transTo == null) ? 0 : transTo.hashCode());
		result = prime * result + ((transType == null) ? 0 : transType.hashCode());
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
		Transaction other = (Transaction) obj;
		if (transAccountId == null) {
			if (other.transAccountId != null)
				return false;
		} else if (!transAccountId.equals(other.transAccountId))
			return false;
		if (transAmount == null) {
			if (other.transAmount != null)
				return false;
		} else if (!transAmount.equals(other.transAmount))
			return false;
		if (transClosingBalnace == null) {
			if (other.transClosingBalnace != null)
				return false;
		} else if (!transClosingBalnace.equals(other.transClosingBalnace))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transFrom == null) {
			if (other.transFrom != null)
				return false;
		} else if (!transFrom.equals(other.transFrom))
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		if (transOption == null) {
			if (other.transOption != null)
				return false;
		} else if (!transOption.equals(other.transOption))
			return false;
		if (transTo == null) {
			if (other.transTo != null)
				return false;
		} else if (!transTo.equals(other.transTo))
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}
	
	
	
	
	
    
}
