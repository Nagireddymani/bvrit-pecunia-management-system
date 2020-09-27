package com.capg.pbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.model.LoanDisburseb;

public interface ILoanDisbursedRepository extends JpaRepository<LoanDisburseb, String>{
	
	public List<LoanDisburseb> findByLoanRequestId(String loanRequestId);
	
}
