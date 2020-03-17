package com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.basetest.TestBase;

public class Utility {
	private static int COUNTER = 1;
	public static SoftAssert assertion;
	private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);

	static int EXPLICIT_WAIT = 15;

	private static ExtentReports extent;
	public static ExtentTest test;
	private static final String REPORT_NAME = "extent.html";

	private final static boolean SUCCESS = true;

	private final static boolean FAIL = false;
	public final static String AUTOMATION_SCREENSHOT_PATH = System.getProperty("user.dir") + "//reports//screenshots//";
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter= new DataFormatter();

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

	}



	public void assertAll() {

		assertion.assertAll();
	}

	public void assertEqual(String expected, String actual, boolean screenshot,ExtentTest childTest) {
		assertion.assertEquals(actual, expected);
		this.postAssert( expected, actual, screenshot,childTest);

	}

	private  void postAssert(String expected, String actual, boolean screenshot,ExtentTest childTest) {

		Status logStatus = Status.PASS;

		if (!expected.equals(actual)) {

			logStatus = Status.FAIL;
		}

		if (screenshot) {

			try {

				String screenshotpath = screenShot();
				childTest.addScreenCaptureFromPath(screenshotpath);
				

			} catch (IOException e) {

				LOGGER.error("Exeption in postAssert: " + e.getMessage());

				e.printStackTrace();

			}
		}

	}

	public  String screenShot() throws IOException {

		File screenshotsource = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss_a");

		String fileName = AUTOMATION_SCREENSHOT_PATH + "Screenshot_" + (++COUNTER) + sdf.format(new Date()) + ".png";

	   FileUtils.copyFile(screenshotsource, new File(fileName));

		return fileName;

	}
	
	public static Object[][] getData(String fileName,String sheetName) throws IOException
	{
	FileInputStream fileInputStream= new FileInputStream(fileName); //Excel sheet file location get mentioned here
		workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
		worksheet=workbook.getSheet(sheetName);// get my sheet from workbook
   	    Row Row=worksheet.getRow(0);   	 //get my Row which start from 0   
   	
    	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
    	int ColNum= Row.getLastCellNum(); // get last ColNum 
    	System.out.println("no os rows>>"+RowNum);
    	System.out.println("no os rows>>"+ColNum);
    	
    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
    	
    		for(int i=0; i<RowNum-1; i++) //Loop work for Rows
    		{  
     			Row row= worksheet.getRow(i+1);
    			
    			for (int j=0; j<ColNum; j++) //Loop work for colNum
    			{
    				if(row==null)
    					Data[i][j]= "";
    				else 
    				{
    					Cell cell= row.getCell(j);
    					if(cell==null)
    						Data[i][j]= ""; //if it get Null value it pass no data 
    					else
    					{
    						String value=formatter.formatCellValue(cell);
    						Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
    					}
    				}
    			}
    		}

    	return Data;
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

	// files utility

	// create file
	public void createFile(String filepath) {
		File f = new File(filepath);
		try {
			if (f.createNewFile()) {
				System.out.println("File got created");
			} else {
				System.out.println("File already created");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// rename file
	public void Renamefile(String source, String Destination) {
		File file = new File(source);
		File renemefile = new File(Destination);
		if (file.renameTo(renemefile)) {
			System.out.println(" file got rename " + renemefile);
		} else {
			System.out.println("file not rename");
		}
	}

	// copy file(source to destination)
	public void copyFile(String source, String destination) throws Exception {
		File sourcefile = new File(source);
		File destinationfile = new File(destination);

		try {
			System.out.println(" Start " + sourcefile);
			Files.copy(sourcefile.toPath(), destinationfile.toPath());
			System.out.println(" finish " + destinationfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Zip file path

	public void zipFile(String Sourcefile, String filename, String Destinationfile) throws IndexOutOfBoundsException {

		byte[] bytesize1 = new byte[1024];

		try {
			FileOutputStream fos1 = new FileOutputStream(Sourcefile);
			ZipOutputStream zos = new ZipOutputStream(fos1);
			ZipEntry ze = new ZipEntry(filename);
			zos.putNextEntry(ze);
			FileInputStream fis1 = new FileInputStream(Destinationfile);

			int z;
			while ((z = fis1.read(bytesize1)) > 0) {
				zos.write(bytesize1, 0, z);
			}

			fis1.close();
			zos.closeEntry();
			zos.close();

			System.out.println("zip file name is Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// delete all file
	public void Deletefile(String filepath) {
		File file1 = new File(filepath);
		if (file1.delete()) {
			System.out.println(" file got deleted: " + file1);
		} else {
			System.out.println("file not deleted");
		}

	}

}
