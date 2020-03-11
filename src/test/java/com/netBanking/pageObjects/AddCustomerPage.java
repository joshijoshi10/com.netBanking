package com.netBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.netBanking.testCases.BaseClass;

public class AddCustomerPage extends BaseClass{

WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement clickNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement customerGender;
	
	@FindBy(how = How.ID, using="dob")
	@CacheLookup
	WebElement customerDob;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement customerAddress;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement customerCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement customerState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement customerPinno;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement customerTelepone;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement customerEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement customerPassword;
	
	@FindBy(how = How.XPATH, using="//input[@name='sub']")
	@CacheLookup
	WebElement clickAddCustomerSubmit;

	
	public void clickNewCustomer() {
		clickNewCustomer.click();
	}
	
	public void CustomerName(String cname) {
		CustomerName.sendKeys(cname);
	}

	public void customerGender(String custGender) {
		customerGender.sendKeys(custGender);
	}

	public void customerDob(String dd, String mm, String yy) {
		customerDob.sendKeys(dd);
		customerDob.sendKeys(mm);
		customerDob.sendKeys(yy);
	}

	public void customerAddress(String custAddr) {
		customerAddress.sendKeys(custAddr);;
	}

	public void customerCity(String custCity) {
		customerCity.sendKeys(custCity);
	}

	public void customerState(String custState) {
		customerState.sendKeys(custState);
	}

	public void customerPinno(String custPinno) {
		customerPinno.sendKeys(custPinno);
	}

	public void customerTelepone(String custTelno) {
		customerTelepone.sendKeys(custTelno);
	}

	public void customerEmail(String custEmail) {
		customerEmail.sendKeys(custEmail);
	}

	public void customerPassword(String custPass) {
		customerPassword.sendKeys(custPass);
	}

	public void clickAddCustomerSubmit() {
		clickAddCustomerSubmit.click();
	}

}
