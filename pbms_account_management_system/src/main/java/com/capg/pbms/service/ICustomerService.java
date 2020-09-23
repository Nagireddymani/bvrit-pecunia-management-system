package com.capg.pbms.service;

import java.util.List;

import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);
	
	boolean removeCustomer(String customerId);
	
	Customer updateCustomer(Customer customer);
	
	Customer getCustomerById(String customerId);
	
	List<Customer> getAllCustomers();
	
	// Transaction Related Methods

	AccountManagement getAccountById(String accountId);
	
	List<AccountManagement> getAllAccounts();
	
	AccountManagement updateAccountManagement(AccountManagement account);
	
}
