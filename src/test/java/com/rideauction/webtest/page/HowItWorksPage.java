package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class HowItWorksPage extends BasePage {
	@FindBy(how=How.XPATH, using="//h1[text()='What is RideAuction.com?']")
	WebElement WHAT_IS_RIDEAUCTION;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(), 'How does it work?')]")
	WebElement HOW_DOES_IT_WORK;
	
	@FindBy (how=How.XPATH, using="//h3[contains(text(), 'Customer Benefits of RideAuction')]")
	WebElement CUSTOMER_BENEFITS;
	
	public HowItWorksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(CUSTOMER_BENEFITS);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		verifyElementVisible(WHAT_IS_RIDEAUCTION);
		verifyElementVisible(HOW_DOES_IT_WORK);
		verifyElementVisible(CUSTOMER_BENEFITS);
	}

}
