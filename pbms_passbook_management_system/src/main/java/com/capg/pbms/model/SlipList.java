package com.capg.pbms.model;

import java.util.List;

public class SlipList {

	private List<Slip> slipList;
	
	public SlipList() {
	
	}

	public SlipList(List<Slip> slipList) {
		super();
		this.slipList = slipList;
	}

	public List<Slip> getSlipList() {
		return slipList;
	}

	public void setSlipList(List<Slip> slipList) {
		this.slipList = slipList;
	}

	@Override
	public String toString() {
		return "SlipList [slipList=" + slipList + "]";
	}
	
	
}
