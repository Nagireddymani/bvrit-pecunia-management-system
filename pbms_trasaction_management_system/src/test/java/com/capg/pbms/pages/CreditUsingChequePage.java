package com.capg.pbms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capg.pbms.baseclass.Library;

public class CreditUsingChequePage extends Library{

	public CreditUsingChequePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"Navbar\"]/div/ul/li[2]/a")
	WebElement navTransactionButton;
	
	@FindBy(xpath ="/html/body/app-root/body/app-trasaction/div/div/div[2]/div/div[1]/div[1]/button")
	WebElement chequeButton;
	
	@FindBy(xpath = "/html/body/app-root/body/app-trasaction/div/div/div[2]/div/div[2]/div[1]/button")
	WebElement creditButton;
	
	@FindBy(id = "accountNum")
	WebElement fromAccountNumText;
	
	@FindBy(id = "toAccountNum")
	WebElement toAccountNumberText;
	
	@FindBy(id = "chequeNum")
	WebElement checkNumberText;
	
	@FindBy(id = "chequeHolderName")
	WebElement holderNameText;
	
	@FindBy(id = "amount")
	WebElement amountText;
	
	@FindBy(id = "chequeBankName")
	WebElement bankNameText;
	
	@FindBy(id = "chequeIFSC")
	WebElement ifscCodeText;
	
	@FindBy(xpath = "/html/body/app-root/body/app-trasaction/div/div/div[2]/div[2]/form/div[9]/div/button")
	WebElement submitButton;
	
	public void goToCreditFormPage()
	{
	    navTransactionButton.click();
	    chequeButton.click();
	    creditButton.click();
	}
	
	public void enterFromAccountNumber(String fromAccountNum)
	{
		fromAccountNumText.sendKeys(fromAccountNum);
	}
	
	public void enterToAccountNumber(String toAccountNum)
	{
		toAccountNumberText.sendKeys(toAccountNum);
	}
	
	public void enterCheckNumber( String checkNum )
	{
		checkNumberText.sendKeys(checkNum);
	}
	
	public void enterHolderName( String holderName )
	{
		holderNameText.sendKeys(holderName);
	}

	public void enterAmount( String amount )
	{
		amountText.sendKeys(amount);
	}

	public void enterBankName( String bankName )
	{
		bankNameText.sendKeys(bankName);
	}
	
	public void enterIFSCCode( String IFSCCode )
	{
		ifscCodeText.sendKeys(IFSCCode);
	}
	
	public void submitForm()
	{
		submitButton.click();
	}
	
}
