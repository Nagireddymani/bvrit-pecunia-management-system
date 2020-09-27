package com.capg.pbms.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.capg.pbms.model.Employee;
import com.capg.pbms.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	private Random random;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
 		
		employee.setEmployeeId(employee.getEmployeeName().toUpperCase()+Integer.toString(random.nextInt(10000000)).substring(0,5));
		return employeeRepository.save(employee);
	}

	@Override
	public boolean removeEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);
		return !employeeRepository.existsById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee validateEmployee(String employeeId, String employeePassword) {

		if (!employeeRepository.existsByEmployeeIdAndEmployeePassword(employeeId, employeePassword)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return employeeRepository.getOne(employeeId);
	}

}
