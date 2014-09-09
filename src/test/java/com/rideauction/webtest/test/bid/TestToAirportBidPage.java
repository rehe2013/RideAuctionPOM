package com.rideauction.webtest.test.bid;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.rideauction.webtest.framework.BaseTest;
import com.rideauction.webtest.page.PassengerInfoPage;
import com.rideauction.webtest.page.ToAirportBidPage;
import com.rideauction.webtest.page.DatePickerPage;
import com.rideauction.webtest.framework.ExcelReader;

public class TestToAirportBidPage extends BaseTest {
	public static final int AVERAGE_PRICE = 0;
	public static final int CONFIRMED_BID_PRICE = 1;
	
	@DataProvider(name="RideDataProvider")
	public Object [][] rideDatatProvider (){
		return ExcelReader.readExcelData("RideInfo.xlsx", "To Airport Ride Info");
	}

	@Test(dataProvider="RideDataProvider")
	public void testAveragePrice (String numPassenger, String hour, String minute,
			String airportValue, String address, String carType, String promoCode,
			String avePrice, String confirmBidPrice, //no use of the following parameters, but need to pass them here
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode){
		
		ToAirportBidPage  toAirportBidPage = homePage.clickOnToAirportBidBtn ();
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
		toAirportBidPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassenger)), 
				hour,
				minute,
				String.valueOf ((int) Float.parseFloat (airportValue)), 
				address, carType, promoCode);
		DatePickerPage  dpp = toAirportBidPage.clickOnDatePicker();
		dpp.pickADay ("May", "30");
		toAirportBidPage.clickOnPriceCheck();
		String[] priceAry = toAirportBidPage.pageAfterPriceCheck();
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[AVERAGE_PRICE])), 
				String.valueOf ((int) Float.parseFloat(avePrice)));
	}
	
	
	@Test(dataProvider="RideDataProvider")
	public void testConfirmBidPrice (String numPassenger, String hour, String minute,
			String airportValue, String address, String carType, String promoCode,
			String avePrice, String confirmBidPrice, //no use of the following parameters, but need to pass them here
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode){
		
		ToAirportBidPage  toAirportBidPage = homePage.clickOnToAirportBidBtn ();
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
		toAirportBidPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassenger)), 
				hour,
				minute,
				String.valueOf ((int) Float.parseFloat (airportValue)), 
				address, carType, promoCode);
		DatePickerPage  dpp = toAirportBidPage.clickOnDatePicker();
		dpp.pickADay ("May", "30");
		toAirportBidPage.clickOnPriceCheck();
		String[] priceAry = toAirportBidPage.pageAfterPriceCheck();
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[CONFIRMED_BID_PRICE])), 
				String.valueOf ((int) Float.parseFloat(confirmBidPrice)));
	}
	
	@Test(dataProvider="RideDataProvider")
	public void testToAirportBuyWithoutAcceptingTerm (String numPassenger, String hour, String minute,
			String airportValue, String address, String carType, String promoCode,
			//no use of the following parameters, but need to pass them here
			String avePrice, String confirmBidPrice,
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode){
		
		ToAirportBidPage  toAirportBidPage = homePage.clickOnToAirportBidBtn ();
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
		toAirportBidPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassenger)), 
				hour,
				minute,
				String.valueOf ((int) Float.parseFloat (airportValue)), 
				address, carType, promoCode);
		DatePickerPage  dpp = toAirportBidPage.clickOnDatePicker();
		dpp.pickADay ("May", "30");
		toAirportBidPage.clickOnPriceCheck();
		toAirportBidPage.pageAfterPriceCheck();	
		toAirportBidPage.clickBuyButtonWithoutAcceptingTerms();
	}
	
	@Test(dataProvider="RideDataProvider")
	public void testToAirportBuyWithAcceptingTerm (String numPassenger, String hour, String minute,
			String airportValue, String address, String carType, String promoCode,
			String avePrice, String confirmBidPrice, //no use of these two parameters, but need to pass them here
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode){
		
		ToAirportBidPage  toAirportBidPage = homePage.clickOnToAirportBidBtn ();
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
		toAirportBidPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassenger)), 
				hour,
				minute,
				String.valueOf ((int) Float.parseFloat (airportValue)), 
				address, carType, promoCode);
		DatePickerPage  dpp = toAirportBidPage.clickOnDatePicker();
		dpp.pickADay ("June", "30");
		toAirportBidPage.clickOnPriceCheck();
		
		toAirportBidPage.pageAfterPriceCheck();
		PassengerInfoPage passengerInfoPage = toAirportBidPage.clickBuyButtonWithAcceptingTerms();
		passengerInfoPage.enterPassengerInfo(name, email, 
				String.valueOf ((int) Float.parseFloat(phoneNum)), billingName, 
				String.valueOf ((int) Float.parseFloat(ccNum)), 
				String.valueOf ((int) Float.parseFloat(expMonth)), 
				String.valueOf ((int) Float.parseFloat(expYear)), 
				String.valueOf ((int) Float.parseFloat(securityCode)));
	}	
}
