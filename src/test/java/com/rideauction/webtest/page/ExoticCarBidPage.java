package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;
//import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

public class ExoticCarBidPage extends BasePage {
	@FindBy (how=How.CSS, using = ".ajaxbody.corner>h1")
	WebElement PAGE_HEADER;
	
	@FindBy (how=How.ID, using="NoOfPass" )
	WebElement NUM_PASSENGERS;
	
	@FindBy (how=How.NAME, using="selectcar")
	WebElement CAR_SELECTOR;
	
	@FindBy (how=How.ID, using="datepicker")
	WebElement DATE_PICKER;
	
	@FindBy (how=How.ID, using="hour")
	WebElement HOUR;
	
	@FindBy (how=How.ID, using="minute")
	WebElement MINUTE;
	
	@FindBy (how=How.NAME, using = "OriginationAddress")
	WebElement ORIGINATION_ADDR;
	
	@FindBy (how=How.NAME, using = "RequestBody")
	WebElement REQUEST;
	
	@FindBy (how=How.NAME, using = "Mail")
	WebElement EMAIL;
	
	@FindBy (how=How.NAME, using = "Phone")
	WebElement PHONE;
	
	@FindBy (how=How.NAME, using = "budget")
	WebElement BUDGET;
	
	@FindBy (how=How.ID, using = "orderexoticsubmit")
	WebElement SUBMIT_BTN;
	
	
	public ExoticCarBidPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(SUBMIT_BTN);
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(NUM_PASSENGERS);
		verifyElementVisible(CAR_SELECTOR);
		verifyElementVisible(ORIGINATION_ADDR);
		verifyElementVisible(REQUEST);
		verifyElementVisible(EMAIL);
		verifyElementVisible(PHONE);
		verifyElementVisible(BUDGET);
	}
	
	public DatePickerPage clickOnDatePicker(){
		verifyAndClick(DATE_PICKER);
		return new DatePickerPage(driver);
	}
	
	public void fillInRideInfo (String numPassengers, String hour, String minute, String carType, 
			String address, String request, String email, String phone, String budget) {
		WaitForElementPresent (DATE_PICKER, 5);
		type (NUM_PASSENGERS, numPassengers);
		selectDropDownByValue (CAR_SELECTOR, carType);
		selectDropDownByValue(HOUR, hour);
		selectDropDownByVisibleText(MINUTE, minute);
		type (ORIGINATION_ADDR, address);
		type (REQUEST, request);
		type (EMAIL, email);
		type (PHONE, phone);	
		verifyAndClick(BUDGET);
		WaitForElementPresent (BUDGET, 5);
		type (BUDGET, budget);
		
	}

	public InquiryConfirmationPage clickOnSubmitBtn (){
		verifyAndClick (SUBMIT_BTN);
		return new InquiryConfirmationPage(driver);
	}
}
