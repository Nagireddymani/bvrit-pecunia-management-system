package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.model.Branch;
import com.capg.pbms.service.IBranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	IBranchService branchService;
	
	@PostMapping("/addbranch")
	public Branch addBranch(@RequestBody Branch branchDetails)
	{
		return branchService.addBranchDetails(branchDetails);
	}
	
	@DeleteMapping("/removebranch/{branchId}")
	public boolean remove(@PathVariable String branchId)
	{
		return branchService.removeBranch(branchId);
	}
	
	@GetMapping("/getallbranchdetails")
	public List<Branch> getAllBranchDetails()
	{
		return branchService.getAllBrancheDetails();
	}
	
}
