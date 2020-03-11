package com.netBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.AddCustomerPage;
import com.netBanking.pageObjects.LoginPage;

import net.bytebuddy.utility.RandomString;

public class TC_AddNewCustomer_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		logger.info("URL is launched");
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addCustomer = new AddCustomerPage(driver);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("scroll(0, 1000)");
		addCustomer.clickNewCustomer();
		
		logger.info("customer creation section.....");
		addCustomer.CustomerName("Shivkumar");
		addCustomer.customerGender("Male");
		addCustomer.customerDob("3", "03", "2020");
		addCustomer.customerAddress("KR Puram");
		addCustomer.customerCity("Bangalore");
		addCustomer.customerState("karnataka");
		addCustomer.customerPinno("560000");
		addCustomer.customerTelepone("6576588786");
		String email= randomString()+"@gmail.com";
		addCustomer.customerEmail(email);
		addCustomer.customerPassword("password");
		addCustomer.clickAddCustomerSubmit();
		logger.info("clicked on add new customer submit button");
		Thread.sleep(8000);
		boolean customerCreate = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(customerCreate==true) {
			Assert.assertTrue(true);
			logger.info("customer cretated successfully");
		}else {
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("customer creation failed");


		}
	}
	public String randomString() {
		String generatestring=RandomString.make(8);
		return generatestring;
	}
}
