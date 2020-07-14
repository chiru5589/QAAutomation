package com.fedex.rlog.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.fedex.rlog.automation.utils.Driver;
import com.fedex.rlog.automation.utils.SeleniumTestHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefinition {
	
	WebDriver driver;
	public static int testDataNo=-1;
	static String currentScenario;
	static String currentStatus;
	static  String productCreationSheetName=null ;
	  
    public CommonStepDefinition(){
    	this.driver = Driver.getInstance();
    }
    @Before
    public void intiate(Scenario scenario){
    	
    	Reporter.log("Execution started for : "+scenario.getName(), true);
    	if(!scenario.getName().equals(currentScenario)){
    		testDataNo=-1;
    		currentScenario = scenario.getName();
    	}
    }
    
    @After
    public void cleanUp(Scenario scenario){
    	
    	System.out.println(scenario.getStatus());
    	
    	if("failed".equals(scenario.getStatus())){
    		try {
    			com.cucumber.listener.Reporter.addScreenCaptureFromPath(SeleniumTestHelper.getFailedScreenshot());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	

  	Driver.closeDriver();
	
	testDataNo=-1;
    }

  	
}
