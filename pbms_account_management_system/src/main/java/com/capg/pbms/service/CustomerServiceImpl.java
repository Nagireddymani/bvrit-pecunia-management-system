package com.capg.pbms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.pbms.exception.AccountManagementException;
import com.capg.pbms.exception.AllAccountException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Address;
import com.capg.pbms.model.Customer;
import com.capg.pbms.repository.IAccountMangementRepository;
import com.capg.pbms.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IAccountMangementRepository accountRepository;
	
	@Autowired
	IAccountMangementRepository accountManagementRepository;

	@Autowired
	private Random random;
	
	@Override
	public Customer addCustomer(Customer customer) {
		customer.setCustomerId(String.valueOf(String.valueOf(Math.abs(random.nextLong())).substring(0, 5)));

		Address address = customer.getCustomerAddress();
		address.setAddressId(String.valueOf(Math.abs(random.nextLong())).substring(0, 5));
		customer.setCustomerAddress(address);

		AccountManagement account = customer.getAccount();
		account.setAccountId(String.valueOf(Math.abs(random.nextLong())).substring(0, 16));
		account.setAccountHolderId(customer.getCustomerId());
		account.setLastUpdated(LocalDateTime.now());
		customer.setAccount(account);

		if (customer.getCustomerName().length() == 0)

			throw new AllAccountException("Name should not be null");

		else if (customer.getCustomerAadhar().length() < 12)
			throw new AllAccountException("Aadhar should be 12 digits");

		else if (customer.getCustomerContact().length() != 10)
			throw new AllAccountException("Contact should be 10 digits ");
		
		else if(!customer.getCustomerPan().matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
			throw new AllAccountException("Pan should be in the proper format ");

		return customerRepository.save(customer);
	}

	@Override
	public boolean removeCustomer(String customerId) {
		if (!customerRepository.existsById(customerId))
			throw new AccountManagementException("Customer with Id " + customerId + " Not Found");

		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		}
		return true;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if (!customerRepository.existsById(customer.getCustomerId())) {
			throw new AccountManagementException("Error: Account not found");

		}

		customer.setCustomerName(customer.getCustomerName());

		customer.setCustomerContact(customer.getCustomerContact());

		Address address = customer.getCustomerAddress();
		customer.setCustomerAddress(address);

		if (customer.getCustomerName().length() == 0)
			throw new AllAccountException("Name should not be null");

		if (customer.getCustomerContact().length() != 10)
			throw new AllAccountException("Contact should be 10 digits");

		if (customer.getCustomerAddress().getAddressLine1().isEmpty())
			throw new AllAccountException("Error:Address  should be given");

		if (customer.getCustomerAddress().getAddressLine2().isEmpty())
			throw new AllAccountException("Error:Address 2 should be given");

		if (!customer.getCustomerAddress().getAddressCity().contains("[A-Za-z]"))
			throw new AllAccountException("Error:City should be only alphabets");

		if (!customer.getCustomerAddress().getAddressState().contains("[A-Za-z]"))
			throw new AllAccountException("Error:State should be only alphabets");

		if (!customer.getCustomerAddress().getAddressCountry().contains("[A-Za-z]"))
			throw new AllAccountException("Error:Country should be only alphabets");

		if (!customer.getCustomerAddress().getAddressZipCode().contains("[0-9]"))
			throw new AllAccountException("Error:PinCode should be only numeric");

		return customerRepository.save(customer);
		 
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		if (!customerRepository.existsById(customerId)) {

			throw new AccountManagementException("Error: Invalid id.");
		}
		return customerRepository.getOne(customerId);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		 if (customerRepository.count() == 0) throw new
		  AccountManagementException(" Error:No Account Found in AccountManagement Database"
		  );
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
		return accountManagementRepository.findAll();
	}

	@Override
	public AccountManagement updateAccountManagement(AccountManagement account) {
		return accountRepository.save(account);
	}   

}
