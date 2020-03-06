package com.test;

import java.io.IOException;


import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.Pages.LoginOR;
import com.Pages.LoginPage;
//import com.Util.Utility;
import com.basetest.TestBase;

public class LoginTest extends TestBase {
	
	public LoginPage loginpage;
	public LoginOR loginor;
	
		public LoginTest(){
			super();
		 loginpage=new LoginPage(driver);
	//	 loginor=new LoginOR(driver);
		}

	/*@Test	
	public void test01(){
		System.out.println("i m in logintest");
	}
	
	@Test(priority = 1)
	public void verifyLoginPage() throws IOException {
		//test = reports.startTest("verify loginTitle page");
	//	ParentTest=reports.createTest("LoginTest");
	//	childTest=ParentTest.createNode("verifyLoginPage");
		
		
		String actTitle1 = loginpage.checkLoginPageTitle();
		
		System.out.println("actTitle>>>>"+actTitle1);
		
		//Utility.info(childTest, "Actual Title" + actTitle1);
		
		String expTitle1 = "JavaByKiran | Log in";
		//Utility.info(childTest, "expected error message");
		if (actTitle1.equals(expTitle1)) {
			//Utility.pass(childTest, "Actual error & Expected error are equals");
			soft.assertEquals(actTitle1, expTitle1);
		} else {
			//Utility.fail(childTest, "Actual error & Expected error are not equals");
			soft.assertEquals(actTitle1, expTitle1);

		}

		soft.assertAll();


	}*/

	@Test(priority = 2)
	public void checkErrorMessage1() throws IOException
	{
		//test = reports.startTest("checkErrorMessage1");
		//ParentTest=reports.createTest("LoginTest");
		//childTest=ParentTest.createNode("checkErrorMessage1");
		//driver.findElement(By.id("email")).sendKeys("kiran111@gmail.com");
	//	Utility.info(childTest, "sending email");
	//	driver.findElement(By.id("password")).sendKeys("123456");
	//	Utility.info(childTest, "sending password");
	//	driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	//	Utility.info(childTest, "clicking on sign In button");
		
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	/*	String actErrorMessage1 = loginor.errorMsg.getText();
		System.out.println("actErrorMessage1"+actErrorMessage1);
		
	//	Utility.info(childTest, "actual error message");
		String expMessage1 = "Please enter email as kiran123@gmail.com";
		
	//	Utility.info(childTest, "expected error message");
		if (actErrorMessage1.equals(expMessage1)) {
	//		Utility.pass(childTest, "Actual error & Expected error are equals");
			soft.assertEquals(actErrorMessage1, expMessage1);
		} else {
	//		Utility.fail(childTest, "Actual error & Expected error are not equals");
			soft.assertEquals(actErrorMessage1, expMessage1);

		}*/

		soft.assertAll();
	}

}
