package com.capg.pbms.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.model.Address;
import com.capg.pbms.model.Branch;
import com.capg.pbms.repository.IBranchRepository;

@Service
public class BranchServiceImpl implements IBranchService{

	@Autowired
	IBranchRepository branchRepository;
	
	@Autowired
	private Random random;
	
	@Override
	public Branch addBranchDetails(Branch branchDetails) {
				
		branchDetails.setBranchId(Integer.toString(random.nextInt(10000000)).substring(0,4));
		
		branchDetails.setBranchIFSC("PECB"+"000"+branchDetails.getBranchId());
		
		Address address= branchDetails.getBranchAddress();
		address.setAddressId(Integer.toString(random.nextInt(10000000)).substring(0,4));
		
		branchDetails.setBranchAddress(address);
		
		return branchRepository.save(branchDetails);
	}

	@Override
	public boolean removeBranch(String branchId) {
		branchRepository.deleteById(branchId);
		return !branchRepository.existsById(branchId);
	}

	@Override
	public List<Branch> getAllBrancheDetails() {
		return branchRepository.findAll();
	}

	
}
