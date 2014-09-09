package com.rideauction.webtest.page;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rideauction.webtest.framework.BasePage;

public class DatePickerPage extends BasePage {
	
	@FindBy (how=How.CSS, using = ".ui-datepicker-calendar" )
	WebElement CALENDER;
	
	@FindBy (how=How.CSS, using = ".ui-datepicker-title" )
	WebElement TITLE;

	@FindBy (how=How.CSS, using =".ui-datepicker-month")
	WebElement MONTH;
	
	@FindBy (how=How.CSS, using ="ui-datepicker-year")
	WebElement YEAR;
	
	@FindBy (how=How.CSS, using =".ui-datepicker-week-end>span[title='Sunday']")
	WebElement SUNDAY;
	
	/**
	 * Left arrow for the Date Picker to go to the previous month.
	 */
	@FindBy(how=How.CSS ,using=".ui-icon.ui-icon-circle-triangle-w")
	WebElement DATE_PICKER_PREV;

	/**
	 * Right arrow for the Date Picker to go to the next month.
	 */
	@FindBy(how=How.CSS ,using=".ui-icon.ui-icon-circle-triangle-e")
	WebElement DATE_PICKER_NEXT;

	Locale locale = Locale.ENGLISH;
	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();
	static final String MM_dd_yyyy = "MM-dd-yyyy";
	final String disabledClassName = "ui-datepicker-unselectable ui-state-disabled ";
	
	public DatePickerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public DatePickerPage(WebDriver driver, Locale locale) {
		super(driver);
		this.locale = locale;
	}

	@Override
	public void waitForPageToLoad() {
		//waitForElementToBeVisible(SUNDAY);
		waitForElementToBeVisible(DATE_PICKER_NEXT);

	}

	@Override
	public void verifyPageElements() {
		verifyElementVisible(TITLE);
		verifyElementVisible(DATE_PICKER_PREV);
		verifyElementVisible(SUNDAY);
	}
	
	public void pickADay (String monthWant, String dayWant){
		
		List rows = CALENDER.findElements(By.tagName("tr"));
		List<WebElement> columns  = CALENDER.findElements(By.tagName("td"));
		
		//for (WebElement row:rows){
			for (WebElement cell: columns){
				String cellClass = cell.getAttribute("class");
				if (!cellClass.contains(disabledClassName) && cell.getText().equalsIgnoreCase(dayWant)){
					//cell.findElement(By.linkText(dayWant)).click();
					cell.click();
					break;
				}	
			}
		//}
	}

}
