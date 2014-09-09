package com.rideauction.webtest.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.rideauction.webtest.framework.PropertyManager.*;

public class WebDriverManager {
	public static final  String MODE_KEY="mode";
	public static final  String HUB_URL_KEY="hubUrl";
	public static final  String BROSER_KEY="browser";
	public static final  String DESIRED_PLATFORM_KEY="platform";
	public static final  String DESIRED_BROWSER_VERSION="browserVersion";
	
	public static WebDriver getWebDriver() {
		try{
			
		
		WebDriver driver;
		String browser=PropertyManager.getProperty("browser");
		String dsplatform= getProperty(DESIRED_PLATFORM_KEY);
		String browserVersion= getProperty(DESIRED_BROWSER_VERSION);
		 DesiredCapabilities caps;
		if("grid".equalsIgnoreCase(getProperty(MODE_KEY))){
			if("firefox".equalsIgnoreCase(browser)){
				caps=DesiredCapabilities.firefox();
				
			}else if("ie".equalsIgnoreCase(browser)){
				//driver=new InternetExplorerDriver();
				caps=DesiredCapabilities.internetExplorer();
				
			} else if("chrome".equalsIgnoreCase(browser)){
				caps=DesiredCapabilities.chrome();
				
			}else{
				caps=DesiredCapabilities.htmlUnitWithJs();
			}
			
			if(dsplatform!=null){
				caps.setCapability(CapabilityType.PLATFORM, dsplatform);
			}
			if(browserVersion!=null){
				caps.setCapability(CapabilityType.VERSION, browserVersion);
				
			}
			 driver=new RemoteWebDriver(new URL(getProperty(HUB_URL_KEY)),caps);
			
		}else{

			
			if("firefox".equalsIgnoreCase(browser)){
				driver=new FirefoxDriver();
				
			}else if("ie".equalsIgnoreCase(browser)){
				File file = new File(PropertyManager.getProperty("InternetExplorerServerPath"));
				//get the path of webdriver exe
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

				DesiredCapabilities capabilities = DesiredCapabilities. internetExplorer();
				capabilities.setCapability(" ignoreZoomSetting", true);
				capabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				 driver =  new InternetExplorerDriver( capabilities);
				driver = new InternetExplorerDriver(capabilities);
				
				
			} else if("chrome".equalsIgnoreCase(browser)){
				File file = new File(PropertyManager.getProperty("ChromeServerPath"));
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
				
				
			}else{
				driver=new HtmlUnitDriver();
			}
		}
		
		
		
		driver.get(PropertyManager.getProperty("appurl"));
//		driver.manage().timeouts().
//		implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
		
	}

}
