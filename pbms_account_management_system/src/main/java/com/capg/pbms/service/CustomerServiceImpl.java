package com.capg.pbms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Customer;
import com.capg.pbms.repository.IAccountMangementRepository;
import com.capg.pbms.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IAccountMangementRepository accountRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public boolean removeCustomer(String customerId) {
		return false;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return null;
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		return null;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
		
	//Transaction Related Methods

	@Override
	public AccountManagement getAccountById(String accountId) {

	
		AccountManagement account=null;
		if(accountRepository.existsById(accountId))
		{
			account= accountRepository.getOne(accountId);
		}
		
		return account;
	}

	@Override
	public List<AccountManagement> getAllAccounts() {
		return null;
	}

	@Override
	public AccountManagement updateAccountManagement(AccountManagement account) {
		return accountRepository.save(account);
	}   

}
