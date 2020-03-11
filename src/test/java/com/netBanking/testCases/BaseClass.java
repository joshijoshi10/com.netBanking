package com.netBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.netBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getAppUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String bros) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j2.properties");
		
		if(bros.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(bros.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}else if(bros.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "C:\\webdrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		Files.copy(source, target);
		System.out.println("shreenshot is taken");
	}
}
