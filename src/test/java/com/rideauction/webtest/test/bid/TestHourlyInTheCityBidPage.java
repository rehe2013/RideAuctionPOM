package com.rideauction.webtest.test.bid;
//this test does not work at all.  I have to rewrite.
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rideauction.webtest.framework.BaseTest;
import com.rideauction.webtest.framework.ExcelReader;
import com.rideauction.webtest.page.DatePickerPage;
import com.rideauction.webtest.page.HourlyInTheCityBidPage;
import com.rideauction.webtest.page.PassengerInfoPage;

public class TestHourlyInTheCityBidPage extends BaseTest {
	public static final int AVERAGE_PRICE = 0;
	public static final int CONFIRMED_BID_PRICE = 1;

	@DataProvider(name="InfoDataProvider")
	public Object [][] infoDatatProvider (){
		return ExcelReader.readExcelData("RideInfo.xlsx", "HourlyCity");
	}
	
	@Test(dataProvider="InfoDataProvider")
	public void testAveragePrice (String numPassengers, String hour, 
			String minute, String numOfHours, String address, 
			String carSeat, String booster, String dog, String carType, String promoCode,
			String averagePrice, String confirmedBidPrice, 
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode) {
		
		HourlyInTheCityBidPage hourlyInTheCityPage = homePage.clickOnHourlyCityBidBtn();
		
		switch ((int)Float.parseFloat (hour)){
			case 0: hour = "00";
					break;
			case 1: hour = "01";
			        break;
			case 2: hour = "02";
			  		break;
			case 3: hour = "03";
			  		break;
			case 4: hour = "04";
			  		break;
			case 5: hour = "05";
			  		break;
			case 6: hour = "06";
			  		break;
			case 7: hour = "07";
			  		break;
			case 8: hour = "08";
			  		break;
			case 9: hour = "09";
			  		break;
		    default: hour = String.valueOf ((int) Float.parseFloat (hour));
		             break;
		}

		hourlyInTheCityPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassengers)), hour, minute, 
				String.valueOf ((int) Float.parseFloat(numOfHours)),
				address, carSeat, booster, dog, carType, promoCode);
		
		DatePickerPage dpp = hourlyInTheCityPage.clickOnDatePicker();
		dpp.pickADay("August", "30");
		
		hourlyInTheCityPage.clickOnPriceCheck();
		String [] priceAry = hourlyInTheCityPage.pageAfterPriceCheck();
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[AVERAGE_PRICE])), 
				String.valueOf ((int) Float.parseFloat(averagePrice)));
	}
	
	@Test(dataProvider="InfoDataProvider")
	public void testConfirmedBidPrice (String numPassengers, String hour, 
			String minute, String numOfHours, String address, 
			String carSeat, String booster, String dog, String carType, String promoCode,
			String averagePrice, String confirmedBidPrice, 
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode) {
		
		HourlyInTheCityBidPage hourlyInTheCityPage = homePage.clickOnHourlyCityBidBtn();
		switch ((int)Float.parseFloat (hour)){
			case 0: hour = "00";
					break;
			case 1: hour = "01";
			        break;
			case 2: hour = "02";
			  		break;
			case 3: hour = "03";
			  		break;
			case 4: hour = "04";
			  		break;
			case 5: hour = "05";
			  		break;
			case 6: hour = "06";
			  		break;
			case 7: hour = "07";
			  		break;
			case 8: hour = "08";
			  		break;
			case 9: hour = "09";
			  		break;
		    default: hour = String.valueOf ((int) Float.parseFloat (hour));
		             break;
		}

		hourlyInTheCityPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassengers)), hour, minute, 
				String.valueOf ((int) Float.parseFloat(numOfHours)),
				address, carSeat, booster, dog, carType, promoCode);
		
		DatePickerPage dpp = hourlyInTheCityPage.clickOnDatePicker();
		dpp.pickADay("Aug", "30");
		
		hourlyInTheCityPage.clickOnPriceCheck();
		String [] priceAry = hourlyInTheCityPage.pageAfterPriceCheck();
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[CONFIRMED_BID_PRICE])), 
				String.valueOf ((int) Float.parseFloat(confirmedBidPrice)));
	}
	

	@Test(dataProvider="InfoDataProvider")
	public void testHourlyInTheCityWithoutAcceptingTerms (String numPassengers, String hour, 
			String minute, String numOfHours, String address, 
			String carSeat, String booster, String dog, String carType, String promoCode,
			String averagePrice, String confirmedBidPrice, 
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode) {
		
		HourlyInTheCityBidPage hourlyInTheCityPage = homePage.clickOnHourlyCityBidBtn();
		switch ((int)Float.parseFloat (hour)){
			case 0: hour = "00";
					break;
			case 1: hour = "01";
			        break;
			case 2: hour = "02";
			  		break;
			case 3: hour = "03";
			  		break;
			case 4: hour = "04";
			  		break;
			case 5: hour = "05";
			  		break;
			case 6: hour = "06";
			  		break;
			case 7: hour = "07";
			  		break;
			case 8: hour = "08";
			  		break;
			case 9: hour = "09";
			  		break;
		    default: hour = String.valueOf ((int) Float.parseFloat (hour));
		             break;
		}

		hourlyInTheCityPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassengers)), hour, minute, 
				String.valueOf ((int) Float.parseFloat(numOfHours)),
				address, carSeat, booster, dog, carType, promoCode);
		
		DatePickerPage dpp = hourlyInTheCityPage.clickOnDatePicker();
		dpp.pickADay("JUNE", "30");
		
		hourlyInTheCityPage.clickOnPriceCheck();
		hourlyInTheCityPage.pageAfterPriceCheck();
		hourlyInTheCityPage.clickBuyButtonWithoutAcceptingTerms();
	}

	
	@Test(dataProvider="InfoDataProvider")
	public void testHourlyInTheCityWithAcceptingTerms (String numPassengers, String hour, 
			String minute, String numOfHours, String address, 
			String carSeat, String booster, String dog, String carType, String promoCode,
			String averagePrice, String confirmedBidPrice, 
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode) {
		
		HourlyInTheCityBidPage hourlyInTheCityPage = homePage.clickOnHourlyCityBidBtn();
		switch ((int)Float.parseFloat (hour)){
			case 0: hour = "00";
					break;
			case 1: hour = "01";
			        break;
			case 2: hour = "02";
			  		break;
			case 3: hour = "03";
			  		break;
			case 4: hour = "04";
			  		break;
			case 5: hour = "05";
			  		break;
			case 6: hour = "06";
			  		break;
			case 7: hour = "07";
			  		break;
			case 8: hour = "08";
			  		break;
			case 9: hour = "09";
			  		break;
		    default: hour = String.valueOf ((int) Float.parseFloat (hour));
		             break;
		}
		
		hourlyInTheCityPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassengers)), hour, minute, 
				String.valueOf ((int) Float.parseFloat(numOfHours)),
				address, carSeat, booster, dog, carType, promoCode);
		
		DatePickerPage dpp = hourlyInTheCityPage.clickOnDatePicker();
		dpp.pickADay("JUNE", "30");
		
		hourlyInTheCityPage.clickOnPriceCheck();
		hourlyInTheCityPage.pageAfterPriceCheck();
		PassengerInfoPage passengerInfoPage = hourlyInTheCityPage.clickBuyButtonWithAcceptingTerms();
		passengerInfoPage.enterPassengerInfo(name, email, 
				String.valueOf ((int) Float.parseFloat(phoneNum)), billingName, 
				String.valueOf ((int) Float.parseFloat(ccNum)), 
				String.valueOf ((int) Float.parseFloat(expMonth)), 
				String.valueOf ((int) Float.parseFloat(expYear)), 
				String.valueOf ((int) Float.parseFloat(securityCode)));
	}
}
