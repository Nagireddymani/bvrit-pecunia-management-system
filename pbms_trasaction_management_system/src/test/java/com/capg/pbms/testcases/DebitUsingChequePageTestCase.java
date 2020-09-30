package com.capg.pbms.testcases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capg.pbms.baseclass.Library;
import com.capg.pbms.pages.DebitUsingChequePage;
import com.capg.pbms.selenium_reuseable_functions.SeleniumUtility;

public class DebitUsingChequePageTestCase extends Library{

	DebitUsingChequePage debitPage;
	SeleniumUtility seleniumUtility;
	
	@BeforeTest
	public void launchApp()
	{
		browserSetUp();
		logger.info("Browser Launched");
	}
	
	@Test(priority = 0)
	public void goToDebitPage()
	{
		debitPage=new DebitUsingChequePage(driver);
		debitPage.goToDebitFormPage();
		logger.info("Debit Using Cheque Form Opened");
	}
	
	@Test(priority = 1)
	public void enterDetails()
	{
		debitPage=new DebitUsingChequePage(driver);
		debitPage.enterAccountNumber(properties.getProperty("accountnumber"));
		debitPage.enterCheckNumber(properties.getProperty("chequenumber"));
		debitPage.enterHolderName(properties.getProperty("holdername"));
		debitPage.enterAmount(properties.getProperty("amount"));
		debitPage.enterBankName(properties.getProperty("bankname"));
		debitPage.enterIFSCCode(properties.getProperty("ifsccode"));
		debitPage.submitForm();
		logger.info("Form Submited");
	}
	
	@AfterTest
	public void close()
	{
		seleniumUtility = new SeleniumUtility(driver);
		seleniumUtility.getTitle();
		seleniumUtility.to_take_screenshot("FormDetails");
		//tearDown();
		logger.info("Closing Browser");
		
	}
	
	
	
}
