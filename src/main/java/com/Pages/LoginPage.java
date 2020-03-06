package com.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginOR {
	
	public LoginPage(WebDriver driver){
		super(driver);
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
	
	

