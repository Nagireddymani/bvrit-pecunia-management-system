package com.capg.pbms.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capg.pbms.baseclass.Library;
import com.capg.pbms.pages.CreditUsingChequePage;
import com.capg.pbms.selenium_reuseable_functions.SeleniumUtility;
public class CreditUsingChequePageTestCase extends Library{

	CreditUsingChequePage creditPage;
	SeleniumUtility seleniumUtility;
	
	@BeforeTest
	public void launchApp()
	{
		browserSetUp();
		logger.info("Browser Launched");
	}
	
	@Test(priority = 0)
	public void goToCreditPage()
	{
		creditPage =new CreditUsingChequePage(driver);
		creditPage.goToCreditFormPage();
		logger.info("Credit Using Cheque Form Opened");
	}
	
	@Test(priority = 1)
	public void enterDetails()
	{
		creditPage =new CreditUsingChequePage(driver);
		
		creditPage.enterFromAccountNumber(properties.getProperty("accountnumber"));
		creditPage.enterToAccountNumber(properties.getProperty("toaccountnumber"));
		creditPage.enterCheckNumber(properties.getProperty("chequenumber"));
		creditPage.enterHolderName(properties.getProperty("holdername"));
		creditPage.enterAmount(properties.getProperty("amount"));
		creditPage.enterBankName(properties.getProperty("bankname"));
		creditPage.enterIFSCCode(properties.getProperty("ifsccode"));
		creditPage.submitForm();
		logger.info("Entered Form Details");
	}
	
	@AfterTest
	public void close()
	{
		seleniumUtility = new SeleniumUtility(driver);
		seleniumUtility.switchToAlert();
		seleniumUtility.getTitle();
		seleniumUtility.to_take_screenshot("CreditFormDetails");
		tearDown();
		logger.info("Closing Browser");
		
	}
}
