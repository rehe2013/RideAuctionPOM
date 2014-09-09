package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class LostPasswordPage extends BasePage {
	@FindBy (how=How.XPATH, using="//a[text()='RideAuction']")
	WebElement RA_HEADER;
	
	@FindBy (how=How.CSS, using=".message")
	WebElement MESSAGE;
	
	@FindBy (how=How.ID, using="user_login")
	WebElement USERNAME_EMAIL;
	
	@FindBy(how=How.ID, using="wp-submit")
	WebElement GET_NEW_PASSWORD;
	
	@FindBy (how=How.XPATH, using="//a[text()='Log in']")
	WebElement LOGIN_LINK;
	
	@FindBy (how=How.XPATH, using="//a[text()='Register']")
	WebElement REGISTRATION_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@title='Are you lost?']")
	WebElement BACK_HOME_LINK;
	
	@FindBy (how=How.ID, using="login_error")
	WebElement ERROR_MSG;
	
	public LostPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(GET_NEW_PASSWORD);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(RA_HEADER);
		verifyElementVisible(MESSAGE);
		verifyElementVisible(USERNAME_EMAIL);
		verifyElementVisible(GET_NEW_PASSWORD);
		verifyElementVisible(LOGIN_LINK);
		verifyElementVisible(REGISTRATION_LINK);
		verifyElementVisible(BACK_HOME_LINK);			
	}

	public LoginPage getPwdWithValidID (String name){
		type (USERNAME_EMAIL, name);
		verifyAndClick(GET_NEW_PASSWORD);
		return new LoginPage (driver);
	}
	
	public void getPwdWithInvalidID (String name){
		type (USERNAME_EMAIL, name);
		verifyAndClick(GET_NEW_PASSWORD);
		verifyElementContainText(ERROR_MSG, "ERROR: Invalid username or e-mail.");
	}
}
