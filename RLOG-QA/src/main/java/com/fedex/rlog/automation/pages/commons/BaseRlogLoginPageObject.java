package com.fedex.rlog.automation.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fedex.rlog.automation.utils.Driver;

public class BaseRlogLoginPageObject {
	

	private WebDriver driver;

	public BaseRlogLoginPageObject() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}


	public void open(String url) {
		Driver.getInstance().get(url);
	}







}
