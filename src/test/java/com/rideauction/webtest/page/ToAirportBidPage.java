package com.rideauction.webtest.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;
//import com.ziffow.webtest.page.ContactPage;
import com.rideauction.webtest.page.PassengerInfoPage;


public class ToAirportBidPage extends BasePage {

	@FindBy (how=How.CSS, using = ".ajaxbody.corner" )
	WebElement AIRPORT_BID_HEADER;
	
	@FindBy (how=How.ID, using = "passengers" )
	WebElement NUM_PASSENGERS;
	
	@FindBy (how=How.ID, using = "datepicker" )
	WebElement DATE_PICKER;
	
	@FindBy (how=How.CSS, using = ".ui-datepicker-calendar" )
	WebElement CALENDER;
	
	@FindBy (how=How.ID, using = "hour" )
	WebElement HOUR;
	
	@FindBy (how=How.ID, using = "minute" )
	WebElement MINUTE;
	
	@FindBy (how=How.ID, using = "ToAirport" )
	WebElement SELECT_AIRPORT_TO;
	
	@FindBy (how=How.NAME, using = "OriginationAddress" )
	WebElement ADDRESS;
	
	@FindBy (how=How.NAME, using = "Car" )
	WebElement CAR_TYPE;
	
	@FindBy (how=How.NAME, using = "PromoCode" )
	WebElement PROMOCODE;
	
	@FindBy (how=How.ID, using = "pricecheck" )
	WebElement PRICECHECK_BTN;
	
	@FindBy (how=How.XPATH, using= "//h2[contains(text(), 'Average Price')]")
	WebElement AVERAGE_PRICE;
	
	@FindBy (how=How.XPATH, using= "//h2[contains(text(), 'Confirmed Ride')]")
	WebElement CONFIRMED_RIDE;

	@FindBy (how=How.CSS, using = ".chekitem")
	List <WebElement> CHECK_ITEMS;
	
	@FindBy (how=How.ID, using = "termscheck")
	WebElement TERMS_CHECK;
	
	@FindBy (how=How.ID, using = "garantserv")
	WebElement BUY_BTN;
	
	@FindBy (how=How.ID, using = "bidsubmit")
	WebElement BID_BTN;
	
	@FindBy (how=How.ID, using="errordiv")
	WebElement BELOW_MINIMUM_BID_MSG;

	@FindBy (how=How.CSS, using =".errorblock.checkboxerror")
	WebElement TERM_CHECKBOX_ERR_MSG;
	
	static final String unCheckedTermErrMsg = "Please read and accept the Terms and Conditions before placing a bid";
	
	public ToAirportBidPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(PRICECHECK_BTN);
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(AIRPORT_BID_HEADER);
		verifyElementVisible(NUM_PASSENGERS);
		verifyElementVisible(DATE_PICKER);
		verifyElementVisible(HOUR);
		verifyElementVisible(MINUTE);
		verifyElementVisible(SELECT_AIRPORT_TO);
		verifyElementVisible(ADDRESS);
		verifyElementVisible(CAR_TYPE);
		verifyElementVisible(PROMOCODE);
	}
	
	public String[]  pageAfterPriceCheck() {
		String[] priceAry  = {null, null};
		WaitForElementToBeClickable(BID_BTN);
		verifyElementVisible(AVERAGE_PRICE);
		String aveLinkText = AVERAGE_PRICE.getText();
		priceAry[0] = aveLinkText.substring(aveLinkText.lastIndexOf('$')+1);	
		for (WebElement elm:CHECK_ITEMS){
			verifyElementVisible(elm);
		}
		
		String confirmedLinkText = CONFIRMED_RIDE.getText();
		priceAry[1] = confirmedLinkText.substring(confirmedLinkText.lastIndexOf('$')+1);	
		verifyElementVisible(TERMS_CHECK);
		verifyElementVisible(BUY_BTN);
		return priceAry;
	}
	
	public  DatePickerPage clickOnDatePicker(){
		verifyAndClick(DATE_PICKER);
		return new DatePickerPage(driver);
	}
	
	public void fillInRideInfo (String numPassengers,  String hour, 
			String minute, String airport, String address, String carType, String promoCode){
		type (NUM_PASSENGERS, numPassengers);
		selectDropDownByValue(HOUR, hour);
		selectDropDownByVisibleText(MINUTE, minute);
		selectDropDownByValue(SELECT_AIRPORT_TO, airport);
		type (ADDRESS, address);
		selectDropDownByValue(CAR_TYPE, carType);
		type (PROMOCODE, promoCode);
	}
	
	public ToAirportBidPage clickOnPriceCheck (){
		verifyAndClick(PRICECHECK_BTN);
		return new ToAirportBidPage(driver);
	}
	
	public void clickBuyButtonWithoutAcceptingTerms (){
		verifyAndClick (BUY_BTN);
		verifyElementContainText(TERM_CHECKBOX_ERR_MSG, unCheckedTermErrMsg);
	}
	
	public PassengerInfoPage clickBuyButtonWithAcceptingTerms (){
		WaitForElementToBeClickable(BUY_BTN);
		verifyAndClick(TERMS_CHECK);
		verifyAndClick (BUY_BTN);
		return new PassengerInfoPage(driver);
	}
}
