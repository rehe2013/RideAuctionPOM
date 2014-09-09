package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class InquiryConfirmationPage extends BasePage {
	public InquiryConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (how = How.ID, using = "exoticclose")
	WebElement OK_BTN;
	
	@FindBy (how = How.XPATH, using = "html/body/div[1]/div/h1" )
	WebElement INQUIRY_CONFIRMATION;
	
	@FindBy (how = How.XPATH, using = "//div[@class='forms']/p")
	WebElement INQUIRY_MSG;

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(OK_BTN);
		
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible (INQUIRY_CONFIRMATION);
		verifyElementVisible (INQUIRY_MSG);
		
	}	
	
	public void dismissConfirmation (){
		verifyAndClick(OK_BTN);
	}
}
