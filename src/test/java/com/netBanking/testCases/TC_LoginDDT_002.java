package com.netBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;
import com.netBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		driver.get(baseURL);
		logger.info("URL is launched");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username entered");
		lp.setPassword(pwd);
		logger.info("password entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login failed");
			Assert.assertTrue(false);
		}else {
			lp.lnkLogout();
			Thread.sleep(3000);
			Assert.assertTrue(true);
			logger.info("login passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/netBanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum; i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
