package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.Base;
import com.PageObject.PageObject;

public class LoginPage extends Base {

	@FindBy(xpath="//input[@type='text']")
	public WebElement emailTxt;
	
	@FindBy(id="password")
	public WebElement passTxt;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	public WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='email_error']")
	public WebElement errorMsg;
	
	/*@FindBy(xpath="//div[@id='blueBarDOMInspector']//i[@class='fb_logo img sp_3_Q1r8_qFcV sx_b88f4c']")
	public WebElement facebookText;*/
	
	public LoginPage(WebDriver driver){

		System.out.println(222);
		PageFactory.initElements(driver, this);
		System.out.println(333);
	}
	
	public void redirectToOtherPage(String url){
		driver.navigate().to(url);
	}
	
	public void forword(){
		driver.navigate().forward();
	}
	
	public void back(){
		driver.navigate().back();
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public String checkCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public String checkLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHeadFacebookText(WebElement element){
		
		return element.isDisplayed();
	}
	
	
	

	public HomePage login(String un,String pwd){
	
		emailTxt.sendKeys(un);	
		passTxt.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
	}
	
	
	
	
	
	}
	
	

