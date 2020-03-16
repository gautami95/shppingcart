package com.test;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.Util.Utility;
import com.basetest.TestBase;

public class LoginTest extends TestBase {

	public LoginPage loginpage;

	/*
	 * @Test(priority = 2) public void checkErrorMessage1() throws IOException {
	 * loginpage=new LoginPage(driver);
	 * loginpage.login(prop.getProperty("username"),
	 * prop.getProperty("password"));
	 * 
	 * }
	 */
	@Test
	public void tc001() {
		WebElement un = driver.findElement(By.xpath("//*[@id='email']"));
		un.sendKeys("kiran@gmail.com");
		WebElement pw = driver.findElement(By.xpath("//*[@id='password']"));
		pw.sendKeys("123456");
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button"));
		loginbtn.click();
		WebElement selmoreinfo = driver
				.findElement(By.xpath("/html/body//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']"));
		selmoreinfo.click();
		/*
		 * loginpage=new LoginPage(driver);
		 * loginpage.login(prop.getProperty("username"),
		 * prop.getProperty("password"));
		 */
		boolean result = Utility
				.switchToWindowByUrlText("file:///E:/Offline%20Website/pages/pdf/selenium-testing-syllabus-jbk.pdf");
		System.out.println("url opened ?>>> " + result);
		
		boolean swtch = Utility.switchToWindowByTitle("JavaByKiran | Dashboard");
		System.out.println("switched back to dashbord>>> "+swtch);
		
		int cnt = Utility.getCountofOpenWindows();
		System.out.println("total no of windows open>>> "+cnt);
		
		ArrayList<String> openWinTitle = Utility.getTitleListofOpenWindows();
		for(String s:openWinTitle){
			System.out.println(s);
		}
		// Utility.closeWindow("Java by Kiran");

	}

}
