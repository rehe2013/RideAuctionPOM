package com.rideauction.webtest.test.bid;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rideauction.webtest.framework.BaseTest;
import com.rideauction.webtest.framework.ExcelReader;
import com.rideauction.webtest.page.DatePickerPage;
import com.rideauction.webtest.page.PointToPointPage;

public class TestPointToPoinBidtPage extends BaseTest {
	public static final int AVERAGE_PRICE = 0;
	public static final int CONFIRMED_BID_PRICE = 1;
	
	public String numPassengers = "4";  
	public String hour = "11";
	public String minute = ":00";
	public String orgAddress = "811 The Dallas Ave. Sunnyvale, CA 94087";
	public String destAddress = "104 San Pedro Road, Daly City, CA";
	public String extraStop = "Y";
	public String NoOfStops = "1";
	public String carSeat = "Y";
	public String booster = "N";
	public String dog = "N";
	public String carType = "SUV";
	public String promoCode = "COUPON";
	public String averagePrice = "175";
	public String confirmedBidPrice = "192";
	public String email = "john@xyz.com";
	public String phoneNum = "4087778888";
	public String billingName = "John Smith";
	public String ccNum = "4321432143214320";
	public String expMonth = "12";
	public String expYear = "2015"; 
	public String securityCode = "321";

	
	/*	
	@DataProvider(name="InfoDataProvider")
	public Object [][] infoDatatProvider (){
		return ExcelReader.readExcelData("PointToPointInfo.xlsx", "sheet1");
	}
	
	@Test(dataProvider="InfoDataProvider")
	public void testAveragePrice (String numPassengers,  String hour, 
			String minute,  String orgAddress, String destAddress, String extraStop, String NoOfStops, 
			String carSeat, String booster, String dog, String carType, String promoCode,
			String averagePrice, String confirmedBidPrice, 
			String name, String email, String phoneNum, String billingName, String ccNum,
			String expMonth, String expYear, String securityCode) {
		*/
	@Test
	public void testGetPrices(){
		
		PointToPointPage p2PPage = homePage.clickonPointBidBtn();
		
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
		
		p2PPage.fillInRideInfo(String.valueOf ((int) Float.parseFloat(numPassengers)), hour, minute, orgAddress, destAddress,
				extraStop, String.valueOf ((int) Float.parseFloat(NoOfStops)), carSeat, booster, dog, carType, promoCode);
		
		DatePickerPage dpp = p2PPage.clickOnDatePicker();
		dpp.pickADay("AUGUST", "30");
		
		p2PPage.clickOnPriceCheck();
		
		String [] priceAry = p2PPage.pageAfterPriceCheck();		
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[AVERAGE_PRICE])), 
				String.valueOf ((int) Float.parseFloat(averagePrice)));	
		
		assertEquals (String.valueOf ((int) Float.parseFloat(priceAry[CONFIRMED_BID_PRICE])), 
				String.valueOf ((int) Float.parseFloat(confirmedBidPrice)));	
	}
}

