package com.fedex.rlog.automation.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fedex.rlog.automation.utils.Driver;

public class LocationsPageObject {
	
	
	WebDriver driver;
	String Dynamic;
	
	public LocationsPageObject() {
		
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
}
