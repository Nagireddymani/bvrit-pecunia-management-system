package com.capg.pbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String>{

}
