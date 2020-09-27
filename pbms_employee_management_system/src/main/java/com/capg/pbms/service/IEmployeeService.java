package com.capg.pbms.service;

import java.util.List;

import com.capg.pbms.model.Employee;

public interface IEmployeeService {

	Employee addEmployee(Employee employee);
	
	boolean  removeEmployee(String employeeId); 
	
	List<Employee> getAllEmployees();
	
	Employee validateEmployee(String employeeId, String employeePassword);
	
}
