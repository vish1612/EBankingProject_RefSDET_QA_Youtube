package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void createNewCustomer() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);

		AddNewCustomerPage addcust = new AddNewCustomerPage(driver);
		addcust.clickAddNewCustLink();
		Thread.sleep(3000);
		addcust.setCustomerName("Naveen");
		addcust.setGender("male");
		addcust.setDOB("19", "10", "1997");
		Thread.sleep(2000);
		addcust.setAddress("Kamothe");
		addcust.setCity("Navi Mumbai");
		addcust.setState("Maharashtra");
		addcust.setPin("412533");
		addcust.setMobileNumber("999788899");
		String email = genRandomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("dfdf@@Ds");
		addcust.clickonSubmitButton();

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "createNewCustomer");
			Assert.assertTrue(false);
		}
	}

	public String genRandomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
}
