package com.fedex.rlog.automation.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"json:target/cucumber-report.json", "html:target/cucumber-report", "com.cucumber.listener.ExtentCucumberFormatter:TestResult/MyOwnReport.html"},
		features={"src/test/resources"},
		glue={"com.fedex.commerce.automation.stepdefinitions"},
		
		
		tags={"@Categories_Validating_the_fields_present_in_display_page"},
		
		
		dryRun = true
		
		
)
@Test
public class DryRunRunner extends AbstractTestNGCucumberTests{
	
	@AfterClass
	public static void teardown() {
        
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
    
   
}


