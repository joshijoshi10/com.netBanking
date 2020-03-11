package com.netBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is launched");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		Thread.sleep(2000);

		lp.clickSubmit();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
}
