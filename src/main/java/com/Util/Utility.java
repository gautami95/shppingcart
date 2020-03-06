package com.Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/*import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;*/
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Utility {
	/*private static int COUNTER = 1;
	public static SoftAssert assertion;
//	private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);

	static int EXPLICIT_WAIT = 15;

	private static ExtentReports extent;
	public static ExtentTest test;
	private static final String REPORT_NAME = "extent.html";

	private final static boolean SUCCESS = true;
	public static WebDriver driver;

	private final static boolean FAIL = false;
	public final static String AUTOMATION_SCREENSHOT_PATH = System.getProperty("user.dir")+"//reports//screenshots//";

	public Utility() {

		assertion = new SoftAssert();
	}
	
	
public static void info(ExtentTest childTest, String message) {
		
		childTest.log(Status.INFO, message);
	}

	public static void pass(ExtentTest childTest, String message) {
		
		childTest.log(Status.PASS, message);
	}

	public static void fail(ExtentTest childTest, String message) {
		
		childTest.log(Status.FAIL, message);
		//return test;

	}
	
	public void assertAll() {

		assertion.assertAll();
	}

	public void assertEqual(String stepName, String expected, String actual, boolean screenshot) {
		assertion.assertEquals(actual, expected);
		this.postAssert(stepName, expected, actual, screenshot);

	}
	
	private  void postAssert(String stepName,String  expected,String  actual, boolean screenshot) {

		Status logStatus = Status.PASS;

		if (!expected.equals(actual)) {

			logStatus = Status.FAIL;
		}


		
		if (screenshot) {

			try {
				
				String screenshotpath = screenShot();
				
			} catch (IOException e) {

				LOGGER.error("Exeption in postAssert: " + e.getMessage());
				
				e.printStackTrace();

			}
		}

	}
	
	public String screenShot() throws IOException {

	//	File screenshotsource = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss_a");

		String fileName = AUTOMATION_SCREENSHOT_PATH + "Screenshot_" + (++COUNTER) + sdf.format(new Date())
				+ ".png";

	//	FileUtils.copyFile(screenshotsource, new File(fileName));

		return fileName;

	}
	
	
		
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance(REPORT_NAME);

		return extent;

	}

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public static void switchToWindow(String windowIdentifier) throws NoSuchWindowException {

		if (switchToWindowByTitle(windowIdentifier)) {
			LOGGER.info("Found window with title: " + windowIdentifier);
		} else if (switchToWindowByUrlText(windowIdentifier)) {
			LOGGER.info("Found window with URL: " + windowIdentifier);
		}

	}

	public static boolean switchToWindowByTitle(String windowTitle) {

		for (String windowHandle : getAllOpenWindows()) {
			if (TestBase.driver.switchTo().window(windowHandle).getTitle().equals(windowTitle)) {
				return SUCCESS;
			}
		}

		return FAIL;
	}

	public static boolean switchToWindowByUrlText(String urlText) {

		for (String windowHandle : getAllOpenWindows()) {
			if (TestBase.driver.switchTo().window(windowHandle).getCurrentUrl().equals(urlText)) {
				return SUCCESS;
			}
		}

		return FAIL;

	}

	public static void closeWindow(String windowTitle) {
		switchToWindow(windowTitle);
		TestBase.driver.close();
	}

	public static int getCountofOpenWindows() {

		return TestBase.driver.getWindowHandles().size();
	}

	public static ArrayList<String> getTitleListofOpenWindows() {

		ArrayList<String> windowsList = new ArrayList<String>();

		int i = 0;

		for (String windowInContext : getAllOpenWindows()) {
			TestBase.driver.switchTo().window(windowInContext);

			if (TestBase.driver.getTitle().isEmpty()) {
				if (TestBase.driver.getCurrentUrl().isEmpty()) {
					test.log(Status.ERROR, "A window has no title or URL");
				} else {
					windowsList.add(i, TestBase.driver.getCurrentUrl().trim());
				}
			} else {
				windowsList.add(i, TestBase.driver.getTitle().trim());
			}

			i++;
		}
		return windowsList;
	}

	private static Set<String> getAllOpenWindows() {
		return TestBase.driver.getWindowHandles();
	}

	public static boolean waitForWindow(int windowNum, int TimeOut) {

		boolean windowFound = false;

		int secondCounter = 0;

		while (!windowFound) {

			try {
				if (getCountofOpenWindows() >= windowNum) {
					windowFound = true;
					Thread.sleep(1000);
					return true;
				}

				Thread.sleep(1000);
				secondCounter++;
				if (secondCounter >= TimeOut) {
					return false;
				}
			} catch (Exception e) {

				// AutomationContextManager.getMethod().log(Status.ERROR,
				// e.getMessage());

			}
		}

		return windowFound;
	}
*/}
