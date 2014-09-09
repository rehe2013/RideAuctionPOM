package com.rideauction.webtest.page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class HomePage extends BasePage {

	@FindBy (how=How.XPATH, using="//img[@title='RideAuction']")
	WebElement LOGO;
	
	@FindBy (how=How.XPATH, using="//a[text()='Open In App Store']")
	WebElement APPSTORE_LINK;
	
	@FindBy(how=How.XPATH, using="//a[@href='/how-it-works/']")
	WebElement HOW_IT_WORKS_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@href='/become-our-partner/']")
	WebElement BECOME_OUR_PARTNER_LINK;
	
	@FindBy (how =How.XPATH, using ="//a[@href='/faq/']")
	WebElement FAQ_LINK;
	
	@FindBy (how =How.XPATH, using="//a[@href='/about-us/']")
	WebElement ABOUT_US_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@href='/corporate/']")
	WebElement CORPORATE_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@href='/contact-us/']")
	WebElement CONTACT_LINK;
	
	//@FindBy (how=How.XPATH, using="//a[@href='/wp-login.php']")
	@FindBy (how=How.XPATH, using="//a[contains(text(),'Login')]")
	WebElement LOGIN_LINK;
	
	@FindBy (how=How.XPATH, using="//a[@href='/wp-login.php?action=register']")
	WebElement REGISTRATION_LINK;
	
	@FindBy(how=How.CSS, using=".phone")
	WebElement PHONE_TEXT;
	
	@FindBy (how=How.XPATH, using="//a[text()='Log Out']")
	WebElement LOGOUT_LINK;
	
	@FindBy (how=How.ID, using="toairport")
	WebElement TO_AIRPORT_RADIO_BTN;
	
	@FindBy (how=How.ID, using="fromairport")
	WebElement From_AIRPORT_RADIO_BTN;
	
	@FindBy (how=How.XPATH, using=".//*[@id='airport']//input[@name='submit']")
	WebElement BID_AIRPORT_BTN;
	
	@FindBy (how=How.XPATH, using=".//*[@id='hourly']/div[1]/label[1]")
	WebElement IN_THE_CITY_RADIO_BTN;
	
	@FindBy (how=How.XPATH, using=".//*[@id='hourly']/div[2]/input")
	WebElement HOURLY_BID_BTN;
	
	@FindBy (how = How.XPATH, using =".//*[@id='transfers']/div[2]/input")
	WebElement POINT_BID_BTN;
	
	@FindBy (how = How.XPATH, using= ".//*[@id='exotic']/div[2]/input")
	WebElement EXOTC_CAR_BID_BTN;
	
	@FindBy (how= How.ID, using ="tweet")
	WebElement TWEETER_ICON;

    static int counter=0;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {		
		//System.out.println("```````` counter = " + counter++);
		waitForElementToBeVisible (PHONE_TEXT);
	}

	@Override
	public void verifyPageElements() {
		// TODO Auto-generated method stub
		verifyElementVisible(LOGO);
		verifyElementVisible(APPSTORE_LINK);
		verifyElementVisible(HOW_IT_WORKS_LINK);
		verifyElementVisible(BECOME_OUR_PARTNER_LINK);
		verifyElementVisible(FAQ_LINK);
		verifyElementVisible(ABOUT_US_LINK);
		verifyElementVisible(CORPORATE_LINK);
		verifyElementVisible(CONTACT_LINK);
		//the following two links are not available after login.
		//verifyElementVisible(LOGIN_LINK);
		//verifyElementVisible(REGISTRATION_LINK);
	}
	
	public void verifyPageElementsAfterLogin() {
		// TODO Auto-generated method stub
		verifyElementVisible(LOGOUT_LINK);
	}
	
	public HowItWorksPage clickOnHowItWorksLink (){
		verifyAndClick(HOW_IT_WORKS_LINK);
		return new HowItWorksPage(driver);
	}

	public BecomeOurPartnerPage clickOnBecomeOurPartnerLink (){
		verifyAndClick (BECOME_OUR_PARTNER_LINK);
		return new BecomeOurPartnerPage(driver);
	}
	
	public RegistrationPage clickOnRegistrationLink (){
		verifyAndClick (REGISTRATION_LINK);
		return new RegistrationPage(driver);
	}
	
	public ContactPage clickOnContactLink (){
		verifyAndClick (CONTACT_LINK);
		return new ContactPage(driver);
	}
	
	public LoginPage clickOnLoginLink (){
		verifyAndClick(LOGIN_LINK);
		return new LoginPage (driver);
	}
	
	public ToAirportBidPage clickOnToAirportBidBtn (){
		verifyAndClick (TO_AIRPORT_RADIO_BTN);
		verifyAndClick (BID_AIRPORT_BTN);
		return new ToAirportBidPage(driver);
	}
	
	public HourlyInTheCityBidPage clickOnHourlyCityBidBtn (){
		verifyAndClick (IN_THE_CITY_RADIO_BTN);
		verifyAndClick (HOURLY_BID_BTN);
		return new HourlyInTheCityBidPage (driver);
	}
	
	public PointToPointPage clickonPointBidBtn (){
		verifyAndClick (POINT_BID_BTN);
		return new PointToPointPage (driver);	
	}
	
	public ExoticCarBidPage clickOnExoticBidBtn (){
		verifyAndClick (EXOTC_CAR_BID_BTN);
		return new ExoticCarBidPage(driver);
	}
	
	public TweeterPage clickOnTweeterIcon (){
		verifyAndClick (TWEETER_ICON);
		ArrayList <String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return new TweeterPage (driver);
	}
}
