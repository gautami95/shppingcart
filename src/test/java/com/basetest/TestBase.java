package com.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.Base.Base;
import com.Util.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase extends Base{
	
	public static FileInputStream fis;
	

	/*public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentTest ParentTest;
	public static ExtentTest childTest;*/
	public static SoftAssert soft;
	
	
	
	@BeforeMethod
	public static void intialization() {
		soft=new SoftAssert();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		String pageloadwait = prop.getProperty("pageloadwaittime");
		long pageload_wait = Long.parseLong(pageloadwait);

		String implicitWait = prop.getProperty("implicitWaitTime");
		long implicit_Wait = Long.parseLong(implicitWait);
		
		if ("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		if ("Firefox".equals(browser)) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageload_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicit_Wait, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	@AfterMethod

	public void closeBrowser(){
		
		driver.close();
	}

	
}
