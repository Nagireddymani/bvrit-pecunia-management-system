package com.capg.pbms.stepdefination;

import com.capg.pbms.baseclass.Library;
import com.capg.pbms.pages.DebitUsingChequePage;
import com.capg.pbms.selenium_reuseable_functions.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DebitUsingChequeSteps extends Library{
	
	DebitUsingChequePage  debitPage;
	SeleniumUtility seleniumUtility;
	
	@Given("Employee is in Debit Using Cheque Form Page")
	public void employee_is_in_Debit_Using_Cheque_Form_Page() {
		browserSetUp();
		debitPage =new DebitUsingChequePage(driver);
		logger.info("Browser Launched");
		debitPage.goToDebitFormPage();
		logger.info("Opened Cheque Form");
	}
	
	@When("Employee Enters Form Details and Click Submit")
	public void employee_Enters_Form_Details_and_Click_Submit() {
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
	
	@Then("Amount is Debited From the Account")
	public void amount_is_Debited_From_the_Account() {
		seleniumUtility = new SeleniumUtility(driver);
		seleniumUtility.switchToAlert();
		seleniumUtility.to_take_screenshot("Credit");
	}


}
