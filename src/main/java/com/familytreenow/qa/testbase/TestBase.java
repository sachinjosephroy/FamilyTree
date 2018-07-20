package com.familytreenow.qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.familytreenow.qa.util.TestUtil;
import com.familytreenow.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	EventFiringWebDriver e_driver;
	WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Sachin Roy\\eclipse-workspace\\Familytreenow\\src\\main\\java\\com\\familytreenow\\qa\\configuration\\configure.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Webdrivers\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

}
