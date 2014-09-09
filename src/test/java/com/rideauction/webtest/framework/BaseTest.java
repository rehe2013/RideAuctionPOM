package com.rideauction.webtest.framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rideauction.webtest.page.HomePage;



public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	Logger logger=Logger.getLogger(BaseTest.class);
	
	@BeforeMethod(alwaysRun=true)
	public void runBeforeEachMethod(Method method){
		logger.info("Starting new test case " +method.getName());
		driver=WebDriverManager.getWebDriver();
		homePage=new HomePage(driver);
	}
	

	@AfterMethod(alwaysRun=true)
	public void takeScreenShotOnFailure(ITestResult result) throws IOException{
		logger.info("End test test case method "+result.getName());
		if(result.isSuccess()==false){
			Calendar calendar = Calendar.getInstance();
			
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String fileName=PropertyManager.getProperty("screen_shot_dir")
					+result.getName()+formater.format(calendar.getTime())
					+".png";
			File  screenShotToCopied= new File(fileName);
			File screenShotFile=null;
			if("grid".equalsIgnoreCase(PropertyManager.getProperty("mode"))){
				 screenShotFile=((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
			}else{
				 screenShotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			}
			
			FileUtils.copyFile(screenShotFile, screenShotToCopied);
		}
		
		
	}
	/*
	@AfterMethod(dependsOnMethods="takeScreenShotOnFailure" ,alwaysRun=true)
	public void runAfterEachMethod(){
		driver.close();
		driver.quit();
	}
	*/
		
	

}
