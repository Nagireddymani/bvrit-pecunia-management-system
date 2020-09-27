package com.capg.pbms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.exception.InvalidAccountNumberException;
import com.capg.pbms.exception.InvalidDatesException;
import com.capg.pbms.model.Dates;
import com.capg.pbms.service.IPassbookService;

@SpringBootTest
class PbmsPassbookManagementSystemApplicationTests {

	@Autowired
	IPassbookService service;
	
	Dates date;
	
	@BeforeEach
	void init()
	{
		date =new Dates(LocalDateTime.now(),LocalDateTime.of(2017,2,13,15,56));
	}
	
	@Test
	void checkErrorsCaseOfGetAllTransaction() {
		Assertions.assertThrows(InvalidAccountNumberException.class, ()->
		{
			service.getAllTransactionsById("548910101012212112");
		});
	}
	
	@Test
	void checkGetAllTransaction() {
		assertEquals(true, service.getAllTransactionsById("548910101000122")!=null);
	}

	@Test
	void checkGetAllTransactionsBtwDates() {
		Assertions.assertThrows(InvalidDatesException.class, ()->
		{
			service.getAllTransactionsBetweenDates(date.getFromDate(), date.getToDate(), "548910101000122");
		});		
	}
}
