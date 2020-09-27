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
	
	/****************************************************************************************************************************
	 * - Method Name : addCustomer 
	 * - Input Parameters : Customer customer 
	 * - Returntype : Cutomer 
	 * - End Point Url : /addcustomer 
	 * -Request Method Type: PostMapping 
	 * - Author : Capgemini 
	 * - Creation Date : 23-08-2020 
	 * - Description:Adding Customer details to the database.
	 ****************************************************************************************************************************/
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	/****************************************************************************************************************************
	 * - Method Name :removeCenter 
	 *- Input Parameters : String customerId 
	 *- Return type : boolean
	 * - End Point Url : /removecustomer/{customerId}
	 *  -Request Method Type: DeleteMapping 
	 *  - Author : Capgemini
	 *   - Creation Date : 23-08-2020
	 *    - Description :removing Customer details to the database by customerId.
	 ****************************************************************************************************************************/
	@DeleteMapping("/removecustomer/{customerId}")
	public boolean removeCustomer(String customerId)
	{
		return customerService.removeCustomer(customerId);
	}
	
	
	/****************************************************************************************************************************
	 * - Method Name :updateCustomer 
	 * - Input Parameters : Customer customer 
	 * - Return type : Customer 
	 * - End Point Url : /updatecustomer
	 *  -Request Method Type: PutMapping 
	 *  - Author : Capgemini 
	 *  - Creation Date : 23-08-2020 
	 *  - Description : Updating Customer details to the database by customerId.
	 ****************************************************************************************************************************/
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	/****************************************************************************************************************************
	 * - Method Name :getAllCustomers 
	 * - Return type : List<Customer>
	 *  - End Point Url: /getallcustomer 
	 *  -Request Method Type: GetMapping 
	 *  - Author : Capgemini 
	 *  - Creation Date : 23-08-2020 
	 * - Description : Getting All Customer details from the database.
	 ****************************************************************************************************************************/
	@GetMapping("/getallcustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}
	
	
	
	/****************************************************************************************************************************
	 * - Method Name :getCustomer - Input Parameters : String customerId - Return
	 * type : Customer - End Point Url : /getcustomer/{customerId} -Request Method
	 * Type: GetMapping - Author : Capgemini - Creation Date : 23-08-2020 -
	 * Description : Getting Customer details from the database by customerId.
	 ****************************************************************************************************************************/

	@GetMapping("/getcustomer/{customerId}")
	
	public Customer getCustomerById(@PathVariable String customerId) {
		return customerService.getCustomerById(customerId);
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
