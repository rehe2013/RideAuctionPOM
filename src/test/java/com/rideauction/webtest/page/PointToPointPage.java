package com.rideauction.webtest.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class PointToPointPage extends BasePage {
	@FindBy (how=How.CSS, using = ".ajaxbody.corner>h1")
	WebElement PAGE_HEADER;
	
	@FindBy (how=How.ID, using="passengers" )
	WebElement NUM_PASSENGERS;
	
	@FindBy (how=How.ID, using="datepicker")
	WebElement DATE_PICKER;
	
	@FindBy (how=How.ID, using="hour")
	WebElement HOUR;
	
	@FindBy (how=How.ID, using="minute")
	WebElement MINUTE;
	
	@FindBy (how=How.NAME, using = "OriginationAddress")
	WebElement ORIGINATION_ADDR;
	
	@FindBy (how=How.NAME, using = "DestinationAddress")
	WebElement DESTINATION_ADDR;
	
	@FindBy (how = How.ID, using = "extralink")
	WebElement EXTRA_LINK;
	
	@FindBy (how = How.ID, using  = "ExtraStop")
	WebElement EXTRA_STOP;
	
	@FindBy (how = How.NAME, using= "NoOfStops")
	WebElement NUM_STOPS;
	
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

	@FindBy (how=How.ID, using = "pricecheck")
	WebElement PRICE_CHECK;
	
	@FindBy (how = How.XPATH, using = ".//div[@class='checkresults']/h2[contains(text(), 'Average Price')]")
	WebElement AVERAGE_PRICE;
	
	@FindBy (how=How.XPATH, using= ".//div[@class='chekitem']/h2[contains(text(), 'Confirmed Ride')]")
	WebElement CONFIRMED_RIDE_PRICE;
	
	@FindBy (how=How.CSS, using = ".chekitem")
	List <WebElement> CHECK_ITEMS;
	
	@FindBy (how=How.ID, using = "bidsubmit")
	WebElement BID_BTN;
	
	@FindBy (how=How.ID, using = "garantserv")
	WebElement BUY_BTN;
	
	@FindBy (how=How.ID, using = "termscheck")
	WebElement TERMS_CHECK;
	
    public PointToPointPage (WebDriver driver) {
    	super (driver);
    }
    
	@Override
	public void waitForPageToLoad() {
		WaitForElementToBeClickable(PRICE_CHECK);
	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(NUM_PASSENGERS);
		verifyElementVisible(ORIGINATION_ADDR);
		verifyElementVisible(DESTINATION_ADDR);
		verifyElementVisible(CAR_TYPE);
		verifyElementVisible(PROMO_CODE);
		verifyElementVisible(EXTRA_LINK);		
	}
	
	public void fillInRideInfo (String numPassengers,  String hour, 
			String minute,  String orgAddress, String destAddress, String extraStop, String NoOfStops, 
			String carSeat, String booster, String dog, String carType, String promoCode){
		
		selectDropDownByValue (NUM_PASSENGERS, numPassengers);
		selectDropDownByValue(HOUR, hour);
		selectDropDownByVisibleText(MINUTE, minute);
		type (ORIGINATION_ADDR, orgAddress);
		type (DESTINATION_ADDR, destAddress);
		verifyAndClick (EXTRA_LINK);
		waitForElementToBeVisible(EXTRA_STOP);
		waitForElementToBeVisible(CAR_SEAT);
		waitForElementToBeVisible(BOOSTER_SEAT);
		waitForElementToBeVisible(HAVE_A_DOG);
		if (extraStop.equalsIgnoreCase("Y")){
			verifyAndClick(EXTRA_STOP);
			selectDropDownByValue (NUM_STOPS, NoOfStops);
		}
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

	public PointToPointPage clickOnPriceCheck (){
		verifyAndClick(PRICE_CHECK);
		return new PointToPointPage(driver);
	}
	
	public String[] pageAfterPriceCheck() {
		String[] priceAry = {null, null};
		WaitForElementToBeClickable(BID_BTN);
		verifyElementVisible(AVERAGE_PRICE);
		String aveLinkText = AVERAGE_PRICE.getText();
		priceAry[0] = aveLinkText.substring(aveLinkText.lastIndexOf('$')+1); //get the amount of average price
		String confirmedLinkText = CONFIRMED_RIDE_PRICE.getText();
		priceAry[1] = confirmedLinkText.substring(confirmedLinkText.lastIndexOf('$')+1); //get the amount of confirm bid price
		
		for (WebElement elm:CHECK_ITEMS){
			verifyElementVisible(elm);
		}
		verifyElementVisible(TERMS_CHECK);
		verifyElementVisible(BUY_BTN);
		
		return priceAry;
	}
}
