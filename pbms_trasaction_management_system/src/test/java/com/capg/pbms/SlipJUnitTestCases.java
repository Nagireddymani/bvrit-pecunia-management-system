package com.capg.pbms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.capg.pbms.exception.InsufficientBalanceException;
import com.capg.pbms.model.Slip;
import com.capg.pbms.service.ITransactionService;

@SpringBootTest
public class SlipJUnitTestCases {

	@Autowired
	ITransactionService transactionService;
	
	Slip slip,slip1,slip2;
	
	@BeforeEach
	void init()
	{
	 slip=new Slip("","912345678902222","Rohankumar","",1000.0,"Pecunia Bank of India", "PECB0001714", LocalDate.now());
	 
	 slip1=new Slip("","91234567890","Rohankumar","",10000.0,"Pecunia Bank of India", "PECB0001714", LocalDate.now());
     
	 slip2=new Slip("","912345678902222","Rohankumar","",100000.0,"Pecunia Bank of India", "PECB0001714", LocalDate.now());
	}
	
	@Test
	void checkCreditUsingSlip() throws RestClientException, URISyntaxException
	{
		assertEquals(true,transactionService.creditAndDebitUsingSlip(slip,"credit")!=null);
	}
	
	@Test
	void checkDebitUsingSlip() throws RestClientException, URISyntaxException
	{
		assertEquals(true,transactionService.creditAndDebitUsingSlip(slip,"debit")!=null);
	}
	
	@Test
	void checkingErrorCaseofCredit() throws RestClientException, URISyntaxException {
		Assertions.assertThrows(Exception.class, ()->
		{
			transactionService.creditAndDebitUsingSlip(slip1, "credit");
		}
		);
	}
	
	@Test
	void checkingErrorCaseofDebit() throws RestClientException, URISyntaxException {
		Assertions.assertThrows(InsufficientBalanceException.class, ()->
		{
			transactionService.creditAndDebitUsingSlip(slip2, "debit");
		}
		);
	}
	
	
}

