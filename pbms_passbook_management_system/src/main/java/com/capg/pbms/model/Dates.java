package com.capg.pbms.model;

import java.time.LocalDateTime;

public class Dates {

	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	
	public Dates() {

	}

	public Dates(LocalDateTime fromDate, LocalDateTime toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Dates [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
}
