package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement linkAddNewCustomer;

	@FindBy(name = "name")
	@CacheLookup
	WebElement txtName;

	@FindBy(name = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(id = "dob")
	@CacheLookup
	WebElement txtDOB;

	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(name = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(name = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtPin;

	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txtMobile;

	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtEmailid;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "sub")
	@CacheLookup
	WebElement clickSubmit;

	public void clickAddNewCustLink() {
		linkAddNewCustomer.click();
	}

	public void setCustomerName(String customerName) {
		txtName.sendKeys(customerName);
	}

	public void setGender(String gender) {
		rdGender.click();
	}

	public void setDOB(String day, String month, String year) {
		txtDOB.sendKeys(day);
		txtDOB.sendKeys(month);
		txtDOB.sendKeys(year);
	}

	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setState(String state) {
		txtState.sendKeys(state);
	}

	public void setPin(String pin) {
		txtPin.sendKeys(String.valueOf(pin)); // sendkeys not acceting integer values hence conveting value
	}

	public void setMobileNumber(String mobileNum) {
		txtMobile.sendKeys(mobileNum);
	}

	public void setEmail(String email) {
		txtEmailid.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickonSubmitButton() {
		clickSubmit.click();
	}

}
