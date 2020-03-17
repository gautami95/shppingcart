package com.basetest;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Base.Base;
import com.Util.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase extends Base {

	public static FileInputStream fis;

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;

	public static ExtentTest childTest;
	public static ExtentTest parentTest;
	

	@BeforeSuite
	public static void setUpSuite() {
		if (extent == null) {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");

		}

		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
	
	  @BeforeClass
	    public  void getClassName(){
	    	parentTest = extent.createTest(getClass().getSimpleName());
	    }
	  

	@BeforeMethod
	public static void intialization(Method method) {
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		childTest = parentTest.createNode(method.getName());

		if ("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/java/driver/chromedriver.exe");
			driver = new ChromeDriver();
			Utility.info(childTest, "browser started");

		}
		if ("Firefox".equals(browser)) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/java/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		Utility.info(childTest, "web application opened");
	}

	@AfterMethod

	public void closeBrowser() {
		extent.flush();
		 driver.close();
		 driver.quit();
	}



}
