package com.rideauction.webtest.test.bid;

import org.testng.annotations.Test;

import com.rideauction.webtest.framework.BaseTest;
import com.rideauction.webtest.page.DatePickerPage;
import com.rideauction.webtest.page.ExoticCarBidPage;
import com.rideauction.webtest.page.HomePage;
import com.rideauction.webtest.page.InquiryConfirmationPage;

public class TestEXoticCarBidPage extends BaseTest {
	@Test
	public void testExoticCarPage(){
		String numPassengers = "8";
		String hour = "08";
		String minute = ":05";
		String carType = "Exotic";
		String address = "837 Fremont Ave., Sunnyvale, CA";
		String request = "request";
		String email = "abc@xyx.com";
		String phone = "408-777-8888";
		String budget = "500";
		
		ExoticCarBidPage exoticCarPage = homePage.clickOnExoticBidBtn ();
		exoticCarPage.fillInRideInfo(numPassengers, hour, minute, carType, address, request, email, phone, 
				budget);
		
		DatePickerPage dpp = exoticCarPage.clickOnDatePicker();
		dpp.pickADay("June", "30");
		
		InquiryConfirmationPage icp = exoticCarPage.clickOnSubmitBtn ();
		icp.dismissConfirmation ();
	}

}
