package com.rideauction.webtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class ContactPage extends BasePage {
	@FindBy (how=How.XPATH, using="//h2[text()='Contact Us']")
	WebElement CONTACT_US_HEADER;
	
	@FindBy (how=How.XPATH, using="//input[@id='your-name']")
	WebElement CONTACT_NAME;
	
	@FindBy (how=How.XPATH, using="//input[@id='your-email']")
	WebElement EMAIL_ADDR;

	@FindBy (how=How.XPATH, using="//input[@id='your-subject']")
	WebElement SUBJECT;
	
	@FindBy (how=How.XPATH, using="//textarea[@id='your-message']")
	WebElement MAIL_MSG;
	
	@FindBy (how=How.XPATH, using="//input[@type='submit' and @value='Send']")
	WebElement SEND_BTN;
	
	@FindBy (how=How.XPATH, using="//form[@class='wpcf7-form sent']/div[last()]")
	WebElement MSG_SENT_OK;
	
	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		waitForElementToBeVisible(SEND_BTN);
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(CONTACT_US_HEADER);
		verifyElementVisible(CONTACT_NAME);
		verifyElementVisible(EMAIL_ADDR);
		verifyElementVisible(SUBJECT);
		verifyElementVisible(MAIL_MSG);
		verifyElementVisible(SEND_BTN);
	}
	
	public void fillInContactInfo (String name, String emailAddr, String subject, String mailMsg){	
		type (CONTACT_NAME, name);
		type (EMAIL_ADDR, emailAddr);
		type (SUBJECT, subject);
		type (MAIL_MSG, mailMsg);
		verifyAndClick(SEND_BTN);
		waitForElementToBeVisible (MSG_SENT_OK); 
		verifyElementContainText(MSG_SENT_OK, "Your message was sent successfully. Thanks.");
	}

}
