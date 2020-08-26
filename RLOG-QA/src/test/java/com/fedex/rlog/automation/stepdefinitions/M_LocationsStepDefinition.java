package com.fedex.rlog.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fedex.rlog.automation.utils.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class M_LocationsStepDefinition {

	WebDriver driver;
	
	public M_LocationsStepDefinition() {
		this.driver = Driver.getInstance();
	}

	@Before
	public void intiate(Scenario scenario) {
			
	}

	@After
	public void cleanUp(Scenario scenario) {

	}
}
