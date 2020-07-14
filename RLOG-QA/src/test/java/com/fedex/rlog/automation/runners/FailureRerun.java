package com.fedex.rlog.automation.runners;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"json:target/rerun_cucumber.json", "html:target/cucumber-report", "com.cucumber.listener.ExtentCucumberFormatter:",
				"rerun:rerun/failed_scenarios.txt"},
				features = {"@rerun/failed_scenarios.txt"}, 
		glue={"com.fedex.commerce.automation.stepdefinitions"},
		
		dryRun = false
	
)
@Test
public class FailureRerun extends AbstractTestNGCucumberTests{
	
	public static String Environment = "Test";
		
	
	
	@BeforeClass
	public void reportSetup() throws IOException{

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String reportPath = "TestResult/MyOwnReport_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date())+".html";
        extentProperties.setReportPath(reportPath);
      
        String dirPath = System.getProperty("user.dir");
        String testFilePath = dirPath + "/config/" + "test.properties";
        String configFilePath = dirPath + "/config/" + "configuration.properties";
        
        File sourceFile = null;
        FileInputStream fileInputStream = null;
        BufferedReader bufferReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferWriter = null;
        
        
        
        if(Environment.equalsIgnoreCase("Test")){
        	sourceFile = new File(testFilePath);
        	fileInputStream = new FileInputStream(sourceFile);
        	bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));   
        	
        }
        
        fileWriter = new FileWriter(configFilePath);
        bufferWriter = new BufferedWriter(fileWriter);
        String aLine = null;
        while ((aLine = bufferReader.readLine()) != null) {
        	bufferWriter.write(aLine);
        	bufferWriter.newLine();
        }
        bufferWriter.flush();
        bufferReader.close();
        bufferWriter.close();
        System.out.println("Config file generated for :- " + Environment + " environment" );
        
     
       
				

	}

	@AfterClass
	public void teardown() {
	
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("Environment",Environment);
        if(System.getProperty("os.name").contains("Windows")){
        	Reporter.setSystemInfo("os", "Windows");
		}else{
			Reporter.setSystemInfo("os", "Linux");
		}
        
    }
    
   
}
