package com.capg.pbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, String>{

	boolean existsByEmployeeIdAndEmployeePassword(String employeeId, String employeePassword);
	
}
