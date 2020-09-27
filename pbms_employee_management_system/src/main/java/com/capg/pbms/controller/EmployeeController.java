package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.model.Employee;
import com.capg.pbms.model.User;
import com.capg.pbms.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}

	@DeleteMapping("/removeemployee/{employeeId}")
	public boolean removeEmployee(@PathVariable String employeeId)
	{
		return employeeService.removeEmployee(employeeId);
	}
	
	@GetMapping("/getallemployeedetails")
	public List<Employee> getAllEmployeeDetails()
	{
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/validatecredentials")
	public Employee validateEmployeeCredentils(@RequestBody User user)
	{
		System.out.println(user);
		return employeeService.validateEmployee(user.getUsername(), user.getPassword());
	}
	
}
