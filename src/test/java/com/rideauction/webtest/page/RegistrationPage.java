package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;
import com.rideauction.webtest.framework.CaptchaService;

public class RegistrationPage extends BasePage {
	@FindBy (how=How.XPATH, using="//a[text()='RideAuction']")
	WebElement RA_HEADER;
	
	@FindBy (how=How.CSS, using=".message.register")
	WebElement REGISTER_HEADER;
	
	@FindBy (how=How.XPATH, using="//input[@name='user_login']")
	WebElement USERNAME;
	
	@FindBy (how=How.XPATH, using="//input[@name='user_email']")
	WebElement EMAIL;
	
	@FindBy (how=How.XPATH, using="//input[@name='user_pass']")
	WebElement PASSWORD;
	
	@FindBy (how=How.XPATH, using="//input[@name='UserPhone']")
	WebElement PHONE;
	
	@FindBy (how=How.XPATH, using="//input[@name='promocode']")
	WebElement PROMOCODE;
	
	@FindBy (how=How.XPATH, using="//img[@id='recaptcha_challenge_image']")
	WebElement RECAPTHA_IMG;
	
	@FindBy (how=How.XPATH, using="//input[@id='recaptcha_response_field' and  @type='text']")
	WebElement RECAPTHA_INPUT;
	
	@FindBy (how=How.XPATH, using="//div[@class='terms']")
	WebElement TERMS;
	
	@FindBy (how=How.XPATH, using="//input[@id='terms' and @type='checkbox']")
	WebElement TERMS_CHECKBOX;
	
	@FindBy (how=How.XPATH, using="//input[@id='wp-submit' and @value='Register']")
	WebElement REGISTER_BTN;
	
	@FindBy (how=How.XPATH, using="//a[text()='Log in']")
	WebElement GO_LOGIN_LINK;
	
	@FindBy (how=How.XPATH, using="//a[text()='Lost your password?']")
	WebElement LOST_PWD_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@title='Are you lost?' and contains (text(), 'Back to RideAuction')]")
	WebElement BACK_TO_RA_LINK;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(REGISTER_BTN);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible (RA_HEADER);
		verifyElementVisible (REGISTER_HEADER);
		verifyElementVisible (USERNAME);
		verifyElementVisible(EMAIL);
		verifyElementVisible (PASSWORD);
		verifyElementVisible (PHONE);
		verifyElementVisible (PROMOCODE);
		verifyElementVisible (RECAPTHA_IMG);
		verifyElementVisible (RECAPTHA_INPUT);
		verifyElementVisible (TERMS);
		verifyElementVisible (TERMS_CHECKBOX);
	}

	public void fillInRegistrationInfo (String userName, String email,String password, String phone, String promoCode, String termChecked){
		type (USERNAME, userName );
		type (EMAIL, email );
		type (PASSWORD, password );
		type (PHONE, phone );
		type (PROMOCODE, promoCode );
		verifyAndClick (TERMS_CHECKBOX);	
		verifyAndClick (REGISTER_BTN);
	}
	
	public HomePage clickOnHomePageLink (){
		verifyAndClick (BACK_TO_RA_LINK);
		return new HomePage(driver);	
	}
	
	/*
	public LoginPage registrationwithValidInfo (String userName, String email,String password, String phone, String promoCode){
		type (USERNAME, userName );
		type (EMAIL, email );
		type (PASSWORD, password );
		type (PHONE, phone );
		type (PROMOCODE, promoCode );
		type (RECAPTHA_INPUT, CaptchaService.getCaptcha());
		verifyAndClick (TERMS_CHECKBOX);
		return new LoginPage (driver);
	}
	*/
	
	
	 
}
