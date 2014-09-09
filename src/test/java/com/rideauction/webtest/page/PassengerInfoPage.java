package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class PassengerInfoPage extends BasePage {

	@FindBy (how=How.ID, using = "finishorder")
	WebElement SUBMIT_BTN;
	
	@FindBy (how=How.CSS, using = "#secondform>h1")
	WebElement PASSENGER_INFO;
	
	@FindBy (how=How.XPATH, using = ".//*[@id='secondform']/div/h1")
	WebElement PAYMENT_INFO;
	
	@FindBy (how=How.ID, using = "FN")
	WebElement NAME;
	
	@FindBy (how=How.CSS, using = ".corner.required.email")
	WebElement EMAIL;
	
	@FindBy (how=How.ID, using = "Phone")
	WebElement PHONE;
	
	@FindBy (how=How.ID, using = "sameabrove")
	WebElement SAME_AS_ABOVE_CHK_BTN;
	
	@FindBy (how=How.ID, using = "BillingFirstName")
	WebElement BILLING_NAME;
	
	@FindBy (how=How.ID, using = "CCNum")
	WebElement CREDIT_CARD_NUM;
	
	@FindBy (how=How.ID, using = "expDateMonth_inpyt")
	WebElement EXP_MONTH;
	
	@FindBy (how=How.ID, using = "expDateYear_inpyt")
	WebElement EXP_YEAR;
	
	@FindBy (how=How.ID, using = "CCThreeDig")
	WebElement SECURITY_CODE;
	
	public PassengerInfoPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(SUBMIT_BTN);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(PASSENGER_INFO);
		verifyElementVisible(PAYMENT_INFO);
		verifyElementVisible(NAME);
		verifyElementVisible(EMAIL);
		verifyElementVisible(PHONE);
		verifyElementVisible(SAME_AS_ABOVE_CHK_BTN);
		verifyElementVisible(BILLING_NAME);
		verifyElementVisible(CREDIT_CARD_NUM);
		verifyElementVisible(EXP_MONTH);
		verifyElementVisible(EXP_YEAR);
		verifyElementVisible(SECURITY_CODE);
		

	}
	
	public void enterPassengerInfo(String name,String email, String phoneNum, 
			String billingName, String creditCard, String expMonth, String expYear, String securityCode) {
		type(NAME, name);
		type(EMAIL, email);
		type(PHONE, phoneNum);
		verifyAndClick(SAME_AS_ABOVE_CHK_BTN);
		type (BILLING_NAME, billingName );
		type (CREDIT_CARD_NUM, creditCard);
		selectDropDownByValue(EXP_MONTH, expMonth);
		selectDropDownByValue(EXP_YEAR, expYear);
		type(SECURITY_CODE, securityCode);
		verifyAndClick (SUBMIT_BTN);
	}
}
