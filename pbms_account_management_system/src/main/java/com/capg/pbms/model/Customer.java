package com.capg.pbms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {
	
	@Id
	private String customerId;
	private String customerName;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="accountId")
	private AccountManagement account;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address customerAddress;
	
	private String customerAadhar;
	private String customerPan;
	private String customerContact;
	private String customerGender;
	private LocalDate customerDob;
	
	public Customer() {
	
	}

	public Customer(String customerId, String customerName, AccountManagement account, Address customerAddress,
			String customerAadhar, String customerPan, String customerContact, String customerGender,
			LocalDate customerDob) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.account = account;
		this.customerAddress = customerAddress;
		this.customerAadhar = customerAadhar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
	}


	public AccountManagement getAccount() {
		return account;
	}

	public void setAccount(AccountManagement account) {
		this.account = account;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomerPan() {
		return customerPan;
	}

	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public LocalDate getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(LocalDate customerDob) {
		this.customerDob = customerDob;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", account=" + account
				+ ", customerAddress=" + customerAddress + ", customerAadhar=" + customerAadhar + ", customerPan="
				+ customerPan + ", customerContact=" + customerContact + ", customerGender=" + customerGender
				+ ", customerDob=" + customerDob + "]";
	}


	
	
}
