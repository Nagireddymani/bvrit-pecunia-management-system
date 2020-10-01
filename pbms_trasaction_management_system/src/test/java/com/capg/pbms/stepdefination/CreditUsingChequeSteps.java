package com.capg.pbms.stepdefination;

import java.util.concurrent.TimeUnit;

import com.capg.pbms.baseclass.Library;
import com.capg.pbms.pages.CreditUsingChequePage;
import com.capg.pbms.pages.DebitUsingChequePage;
import com.capg.pbms.selenium_reuseable_functions.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditUsingChequeSteps extends Library{

	CreditUsingChequePage creditPage;
	SeleniumUtility seleniumUtility;

	@Given("Employee is in Credit Using Cheque Form Page")
	public void employee_is_in_Credit_Using_Cheque_Form_Page() {
	    browserSetUp();
		creditPage = new CreditUsingChequePage(driver);
		logger.info("Browser Launched");
		creditPage.goToCreditFormPage();
		logger.info("Opened Cheque Form");
	}
	
	@When("Employee Enters Cheque Form Details and Click Submit")
	public void employee_Enters_Cheque_Form_Details_and_Click_Submit() {
		
		creditPage =new CreditUsingChequePage(driver);
		
		creditPage.enterFromAccountNumber(properties.getProperty("accountnumber"));
		creditPage.enterToAccountNumber(properties.getProperty("toaccountnumber"));
		creditPage.enterCheckNumber(properties.getProperty("chequenumber"));
		creditPage.enterHolderName(properties.getProperty("holdername"));
		creditPage.enterAmount(properties.getProperty("amount"));
		creditPage.enterBankName(properties.getProperty("bankname"));
		creditPage.enterIFSCCode(properties.getProperty("ifsccode"));
		creditPage.submitForm();
		logger.info("Submit Button Clicked");
	}
	
	@Then("Amount is Credited From the FromAccountNumber to ToAccountNumber")
	public void amount_is_Credited_From_the_FromAccountNumber_to_ToAccountNumber() {
	    seleniumUtility = new SeleniumUtility(driver);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		seleniumUtility.switchToAlert();
		seleniumUtility.to_take_screenshot("Credit");
		tearDown();
	}

}
