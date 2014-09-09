package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rideauction.webtest.framework.BasePage;

public class TweeterPage extends BasePage {

	@FindBy (how=How.CLASS_NAME, using="ProfileAvatar-image ")
	WebElement RA_IMG;
	
	public TweeterPage (WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(RA_IMG);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub

	}

}
