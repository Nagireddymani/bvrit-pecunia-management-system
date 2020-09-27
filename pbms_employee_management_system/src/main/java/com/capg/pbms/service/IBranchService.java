package com.capg.pbms.service;

import java.util.List;

import com.capg.pbms.model.Branch;

public interface IBranchService {
	
	Branch addBranchDetails(Branch branchDetails);
	
	boolean removeBranch(String branchId);
	
	List<Branch> getAllBrancheDetails();
	
	
}
