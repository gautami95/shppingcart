package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.PageObject.PageObject;

public class LoginOR extends PageObject {
	@FindBy(xpath = "//input[@type='text']")
	public WebElement emailTxt;

	@FindBy(id = "password")
	public WebElement passTxt;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[@id='email_error']")
	public WebElement errorMsg;

	/*
	 * @FindBy(
	 * xpath="//div[@id='blueBarDOMInspector']//i[@class='fb_logo img sp_3_Q1r8_qFcV sx_b88f4c']"
	 * ) public WebElement facebookText;
	 */
	//WebDriver driver;

	public LoginOR(WebDriver driver) {
		super(driver);
	//	this.driver = driver;
	}

}
