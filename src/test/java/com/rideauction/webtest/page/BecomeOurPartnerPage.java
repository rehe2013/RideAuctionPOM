package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class BecomeOurPartnerPage extends BasePage {

	@FindBy (how=How.CSS, using =".button-primary.corner")
	WebElement CONTINUE_BTN;
	
	@FindBy (how=How.XPATH, using ="//h1[text()='Become Our Partner']")
	WebElement BECOME_OUR_PARTNER_HEADER;
	
	@FindBy (how=How.XPATH, using ="//h3[text()='How does it work?']")
	WebElement HOW_DOES_IT_WORK;
	
	@FindBy (how=How.XPATH, using ="//h3[text()='Vendor Benefits of RideAuction:']")
	WebElement VENDOR_BENEFITS;
	
	@FindBy (how=How.XPATH, using ="//h3[text()='Partner Beta Program:']")
	WebElement PARTNER_BETA_PRGM;
	
	
	public BecomeOurPartnerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(CONTINUE_BTN);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(BECOME_OUR_PARTNER_HEADER);
		verifyElementVisible(HOW_DOES_IT_WORK);
		verifyElementVisible(VENDOR_BENEFITS);
		verifyElementVisible(PARTNER_BETA_PRGM);
		verifyElementVisible(CONTINUE_BTN);		
	}

}
