package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base;

public class PageObject extends Base {
	//public WebDriver driver;

	public PageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	//	this.driver = driver;
	}

}
