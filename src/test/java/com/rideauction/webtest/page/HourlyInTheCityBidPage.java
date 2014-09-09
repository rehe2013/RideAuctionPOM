package com.rideauction.webtest.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class HourlyInTheCityBidPage extends BasePage {

	@FindBy (how = How.ID, using = "pricecheck" )
	WebElement PRICE_CHECK_BTN;
	
	@FindBy (how = How.ID, using = "passengers")
	WebElement NUM_PASSENGER;
	
	@FindBy (how=How.ID, using = "datepicker" )
	WebElement DATE_PICKER;
	
	@FindBy (how = How.ID, using = "hour")
	WebElement HOUR_SELECT;
	
	@FindBy (how = How.ID, using = "minute")
	WebElement MINUTE_SELECT;
	
	@FindBy (how = How.XPATH, using = ".//select[@name='NumberOfHours']")
	WebElement NUMBER_OF_HOURS;
	
	@FindBy (how = How.XPATH, using = ".//textarea[@name='OriginalAddress']")
	WebElement ORG_ADDRESS;
	
	@FindBy (how = How.ID, using = "extralink")
	WebElement EXTRA;
	
	@FindBy (how = How.XPATH, using = ".//input[@value='Car Seat']")
	WebElement CAR_SEAT;
	
	@FindBy (how = How.XPATH, using = ".//input[@value='Booster Seat']")
	WebElement BOOSTER_SEAT;
	
	@FindBy (how = How.XPATH, using = ".//input[@value='I have a dog']")
	WebElement HAVE_A_DOG;
	
	@FindBy (how = How.ID, using = "Car")
	WebElement CAR_TYPE;
	
	@FindBy (how = How.NAME, using = "PromoCode")
	WebElement PROMO_CODE;
	
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

	@FindBy (how=How.CSS, using =".errorblock.checkboxerror")
	WebElement TERM_CHECKBOX_ERR_MSG;
	
	static final String unCheckedTermErrMsg = "Please read and accept the Terms and Conditions before placing a bid";

	
	public HourlyInTheCityBidPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(PRICE_CHECK_BTN);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible (NUM_PASSENGER);
		verifyElementVisible (HOUR_SELECT);
		verifyElementVisible (MINUTE_SELECT);
		verifyElementVisible (NUMBER_OF_HOURS);
		verifyElementVisible (ORG_ADDRESS);
		verifyElementVisible (EXTRA);
		verifyElementVisible (CAR_TYPE);
		verifyElementVisible (PROMO_CODE);
	}

	public void fillInRideInfo (String numPassengers,  String hour, 
				String minute,  String numOfHours, String address, String carSeat, String booster, String dog, String carType, String promoCode){
		
		selectDropDownByValue (NUM_PASSENGER, numPassengers);
		selectDropDownByValue(HOUR_SELECT, hour);
		selectDropDownByVisibleText(MINUTE_SELECT, minute);
		selectDropDownByValue(NUMBER_OF_HOURS, numOfHours);
		type (ORG_ADDRESS, address);
		verifyAndClick (EXTRA);
		waitForElementToBeVisible(CAR_SEAT);
		waitForElementToBeVisible(BOOSTER_SEAT);
		waitForElementToBeVisible(HAVE_A_DOG);
		if (carSeat.equalsIgnoreCase("y")) {
			verifyAndClick(CAR_SEAT);
		}
		if (booster.equalsIgnoreCase("Y")){
			verifyAndClick(BOOSTER_SEAT);
		}
		if (dog.equalsIgnoreCase("Y")){
			verifyAndClick(HAVE_A_DOG);
		}
		selectDropDownByValue(CAR_TYPE, carType);
		type (PROMO_CODE, promoCode);
	}
	
	public  DatePickerPage clickOnDatePicker(){
		verifyAndClick(DATE_PICKER);
		return new DatePickerPage(driver);
	}
	
	public HourlyInTheCityBidPage clickOnPriceCheck (){
		verifyAndClick(PRICE_CHECK_BTN);
		return new HourlyInTheCityBidPage(driver);
	}
	
	public String[] pageAfterPriceCheck() {
		String[] priceAry = {null, null};
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
	
	public void clickBuyButtonWithoutAcceptingTerms (){
		verifyAndClick(BUY_BTN);
		verifyElementContainText(TERM_CHECKBOX_ERR_MSG, unCheckedTermErrMsg);
	}
	
	public PassengerInfoPage clickBuyButtonWithAcceptingTerms (){
		WaitForElementToBeClickable(BUY_BTN);
		//verifyPageElements();
		verifyAndClick(TERMS_CHECK);
		verifyAndClick (BUY_BTN);
		return new PassengerInfoPage(driver);
	}

}
