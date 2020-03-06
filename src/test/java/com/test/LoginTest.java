package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.basetest.TestBase;

public class LoginTest extends TestBase {

	public LoginPage loginpage;

	@Test(priority = 2)
	public void checkErrorMessage1() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

}
