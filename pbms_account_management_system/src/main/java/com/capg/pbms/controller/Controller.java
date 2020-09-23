package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Customer;
import com.capg.pbms.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class Controller {
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	@DeleteMapping("/removecustomer/{customerId}")
	public boolean removeCustomer(String customerId)
	{
		return customerService.removeCustomer(customerId);
	}
	
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/getallcustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}
	
	
	
	
	// Transaction Related Methods
	
	@GetMapping("/getaccount/{accountId}")
	public AccountManagement getAccountById(@PathVariable String accountId)
	{
		return customerService.getAccountById(accountId);
	}
	
	@PutMapping("/updateaccount")
	public AccountManagement updateAccount(@RequestBody AccountManagement account) 
	{
		return customerService.updateAccountManagement(account);
	}
	
	@GetMapping("/getallaccounts")
	public List<AccountManagement> getAllAccounts()
	{
		return customerService.getAllAccounts();
	}
		
}
