package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class LoginPage extends BasePage {
	@FindBy (how=How.XPATH, using="//a[text()='RideAuction']")
	WebElement RA_HEADER;
	
	@FindBy (how=How.XPATH, using="//input[@id='user_login']")
	WebElement USERNAME;
	
	@FindBy (how=How.XPATH, using="//input[@id='user_pass']")
	WebElement PASSWORD;
	
	@FindBy (how=How.ID, using="rememberme")
	WebElement REMEMBERME_CHK_BOX;
	
	@FindBy (how=How.XPATH, using="//input[@value='Log In']")
	WebElement SUMMIT_BTN;
	
	@FindBy (how=How.XPATH, using="//div[@id='login_error']")
	WebElement INVAID_ID_MSG;
	
	@FindBy (how=How.XPATH, using="//a[text()='Register']")
	WebElement REGISTRATION_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@title='Are you lost?']")
	WebElement BACK_HOME_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@title='Password Lost and Found']")
	WebElement LOST_PWD_LINK;
	
	@FindBy (how=How.XPATH, using="//a[text()='Log Out']")
	WebElement LOGOUT_LINK;
	
	@FindBy (how=How.CSS, using=".message")
	WebElement CONFIRMATION_MSG;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(SUMMIT_BTN);
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(RA_HEADER);
		verifyElementVisible(USERNAME);
		verifyElementVisible(PASSWORD);
		verifyElementVisible(REMEMBERME_CHK_BOX);
		verifyElementVisible(SUMMIT_BTN);
		//verifyElementVisible(REGISTRATION_LINK);
		verifyElementVisible(BACK_HOME_LINK);
		//verifyElementVisible(LOST_PWD_LINK);
	}

	public void fillInLoginInfo (String userName, String password){
		type (USERNAME, userName);
		type (PASSWORD, password);
		verifyAndClick (SUMMIT_BTN);
	}
	
	public HomePage loginWithValidUserId (String userName, String password){
		//more codes here
		type (USERNAME, userName);
		type (PASSWORD, password);
		verifyAndClick (SUMMIT_BTN);
		return new HomePage (driver);
	}
	
	public void loginWithInvalidUserId (String userName, String password){
		type (USERNAME, userName);
		type (PASSWORD, password);
		verifyAndClick (SUMMIT_BTN);
		waitForElementToBeVisible(INVAID_ID_MSG);
	}
	
	
	public HomePage clickBackToRideAuctionLink (){
		verifyAndClick (BACK_HOME_LINK);
		return new HomePage (driver);
	}
	
	public RegistrationPage clickToRegistrationLink (){
		verifyAndClick (REGISTRATION_LINK);
		return new RegistrationPage (driver);
	}
	
	
	public LostPasswordPage clickLostPwdLink (){
		verifyAndClick (LOST_PWD_LINK);
		return new LostPasswordPage (driver);
	}
	
	public void verifyConfirmationMsg (){
		verifyElementContainText(CONFIRMATION_MSG, "Check your e-mail for the confirmation link.");
	}
	
}
