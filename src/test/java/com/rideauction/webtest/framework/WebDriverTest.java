package com.rideauction.webtest.framework;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverTest {
	
	protected WebDriver driver=null;
	@BeforeMethod
	public void runBeforeEachTestCase(){
		 driver=WebDriverManager.getWebDriver();
//		driver.get("http://www.ziffowinfotech.com");
//		
//		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

	@AfterMethod(alwaysRun=true)
	public void takeScreenShotOnFailure(ITestResult result) throws IOException{
		//logger.info("End test test case method "+result.getName());
		
		
		if(result.isSuccess()==false){
			Calendar calendar = Calendar.getInstance();
			//
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			//Create a file name for the screen shot.
			String fileName=PropertyManager.getProperty("screen_shot_dir")
					+result.getName()+formater.format(calendar.getTime())
					+".png";
			//create a file on disk to store  the screen shot image
			File  screenShotToCopied= new File(fileName);
			//capture screen shot
			File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//store on disk
			FileUtils.copyFile(screenShotFile, screenShotToCopied);
		}
		
		
	}
	
	
	@AfterMethod(alwaysRun=true, dependsOnMethods="takeScreenShotOnFailure")
	public void runAfterEachTestCase(){
		/*
		driver.close();
		driver.quit();
		*/
	}
	/**
	 * To get Web Element
	 * @param elmLocator
	 * @return
	 */
	public WebElement getElement(By elmLocator){
		try{
			return driver.findElement(elmLocator);
			
		}catch(Exception ex){
			//logger.error("Error while finding an element", ex);
			ex.printStackTrace();
		}
		return null;
		
	}
	public void verifyAndClick(By elmLocator){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		elm.click();
	}
/**
 * check if element is present or not . If present returns true otherwise false
 * @param elmLocaotr
 * @return
 */
	public boolean isElementPresent(By elmLocator){
		if(getElement(elmLocator)==null){
			return false;
		}else{
			return true;
		}
			
		
	}
	/**
	 * To Type into text box . takes two parameter 
	 * @param elmLocator:- Locator of element
	 * @param value :- Value to be typed
	 */
	
	public void type(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		elm.sendKeys(value);
		
	}
	/**
	 *  To select a value from drop down box
	 * @param elmLocator :- Element Locator
	 * @param value :value to be selected
	 */
	public void selectDropDownByVisibleText(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		Select select=new Select(elm);
		select.selectByVisibleText(value);
		
	}
	
	
	/**
	 *  To select a value from drop down box
	 * @param elmLocator :- Element Locator
	 * @param value :value to be selected
	 */
	public void selectDropDownByValue(By elmLocator,String value){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		Select select=new Select(elm);
		select.selectByValue(value);
		
	}
	/**
	 *  Wait for a element Present
	 * @param elmLocator Locator of the element
	 * @param timeInSecs time in seconds
	 */
	public void waitForElementPresent(By elmLocator,long timeInSecs){
		WebDriverWait wait=new WebDriverWait(driver,timeInSecs);
		wait.until(ExpectedConditions.presenceOfElementLocated(elmLocator));
		
	}
	
	public void verifyElementSelected(By elmLocator){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		AssertJUnit.assertTrue(elm.isSelected());
		
	}
	public void verifyElementEnabled(By elmLocator){
		WebElement elm=getElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		AssertJUnit.assertTrue(elm.isEnabled());
		
	}
	
	public void verifyText(By elmLocator, String text){
		
		WebElement  elm = driver.findElement(elmLocator);
		AssertJUnit.assertNotNull(elm);
		AssertJUnit.assertEquals (elm.getText(), text);
		
	}
	
	
	//added by Cindy Jao
	public void verifyNumElm (By elmLocator, int expectedNum){
		int count  = driver.findElements(elmLocator).size();
		AssertJUnit.assertEquals(count, expectedNum);
	}

	// added by Cindy Jao
	public void pickADay (By eleLocator, String disabledClassName, String dayWant){
		WebElement dateWidget = driver.findElement(eleLocator);
		List rows = dateWidget.findElements(By.tagName("tr"));
		List<WebElement> columns  = dateWidget.findElements(By.tagName("td"));
		
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
