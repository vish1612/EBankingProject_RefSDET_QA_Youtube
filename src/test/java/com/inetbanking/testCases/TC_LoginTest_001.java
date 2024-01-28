package com.inetbanking.testCases;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public static void loginTest() throws IOException {
		//driver.get(baseURL);
		
		logger.info("=================URL is Opened===================");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("mngr546787");
		logger.info("=================Entered UserName===================");
		
		lp.setPassword("qAderap");
		logger.info("=================Entered Password===================");
		
		lp.clickLogin();
		logger.info("=================Click on Login Button===================");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info("=================Login Test Passed===================");
			
		} else {
			captureScreen(driver, "loginTest");
			AssertJUnit.assertTrue(false);
		}
	}
}
