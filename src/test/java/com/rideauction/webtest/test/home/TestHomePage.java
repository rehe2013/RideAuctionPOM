package com.rideauction.webtest.test.home;

import org.testng.annotations.Test;

import com.rideauction.webtest.framework.BaseTest;
import com.rideauction.webtest.page.*;



public class TestHomePage extends BaseTest {

	public TestHomePage() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testClickOnHowItWorksLink (){
		HowItWorksPage  howItWorksPage = homePage.clickOnHowItWorksLink();
		howItWorksPage.verifyPageElements();
	}
	
	@Test
	public void testClickOnBecomeOurPartnerLink(){
		BecomeOurPartnerPage becomeOurPartnerPage = homePage.clickOnBecomeOurPartnerLink();
		becomeOurPartnerPage.verifyPageElements();
	}
	
	@Test
	public void testFillInRegistrationInfo (){
		RegistrationPage registrationPage = homePage.clickOnRegistrationLink();
		registrationPage.fillInRegistrationInfo("wang", "abc@xyz.com", "password", "408-777-8888", "COUNPON", "Y");
	}
	
	//@Test
	public void testClickOnHomePageLink (){
		RegistrationPage registrationPage = homePage.clickOnRegistrationLink();
		homePage = registrationPage.clickOnHomePageLink ();
	}
	
	@Test
	public void testFillInContactInfo (){
		ContactPage contactPage = homePage.clickOnContactLink();
		contactPage.fillInContactInfo ("Henry", "abc@xyz.com", "Test Subject", "Test Message");	
	}
	
	/*
	@Test 
	public void testFillInLoginInfo (){
		LoginPage loginPage = homePage.clickOnLoginLink();
		loginPage.fillInLoginInfo("Cindy", "password");
	}
	*/
	
	@Test
	public void testErrorTextAfterInvalidLogin (){
		LoginPage loginPage = homePage.clickOnLoginLink();
		loginPage.loginWithInvalidUserId ("natalie", "test123");
	}
	
	@Test
	public void testBackToRideAuctionLinkFromLogin (){
		LoginPage loginPage = homePage.clickOnLoginLink();
		homePage = loginPage.clickBackToRideAuctionLink();
	}
	
	@Test
	public void testLoginWithValidInfo (){
		LoginPage loginPage = homePage.clickOnLoginLink();
		homePage= loginPage.loginWithValidUserId("Cindy", "password");
		homePage.verifyPageElementsAfterLogin();		
	}
	
	
	@Test
	public void testGetPwdWithValidID (){
		LostPasswordPage lostPasswordPage = homePage.clickOnLoginLink().clickLostPwdLink();
		LoginPage loginPage = lostPasswordPage.getPwdWithValidID ("Cindy");
		loginPage.verifyConfirmationMsg ();
	}
	
	@Test
	public void testGetPwdWithInvalidID (){
		LostPasswordPage lostPasswordPage = homePage.clickOnLoginLink().clickLostPwdLink();
		lostPasswordPage.getPwdWithInvalidID ("ACME");
	}
    
	@Test
	public void testSwitchToTweeter(){
		TweeterPage tweeterPage = homePage.clickOnTweeterIcon();
	}
}
