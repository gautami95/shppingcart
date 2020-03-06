package com.basetest;

import java.io.FileInputStream;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.Base.Base;


public class TestBase extends Base{
	
	public static FileInputStream fis;

	public static SoftAssert soft;
	
	@BeforeMethod
	public static void intialization() {
		soft=new SoftAssert();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if ("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		if ("Firefox".equals(browser)) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
	}
	
	
	@AfterMethod

	public void closeBrowser(){
		
		//driver.close();
	}

	
}
