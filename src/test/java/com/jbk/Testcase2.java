package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Testcase2 {
	public static WebDriver driver;
	@BeforeSuite
	public void setup(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/driver/chromedriver78.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	@Test(groups="Regression")
	  public void checkTitle() {
		  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("gaubhadane@gmail.com");
		  Assert.assertEquals(driver.getTitle(), "Log in to Facebook | Facebook");
	  }
	  
	  @Test(groups="Smoke Test")
	  public void checkUsersTitle(){
		  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='_5iyx']")).getText(), "Facebook helps you connect and share with the people in your life.");
	  }
	  
	  @AfterSuite
	  public void close(){
		  driver.close();
	  }
}
