package com.fedex.rlog.automation.stepdefinitions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fedex.rlog.automation.pages.Administration.UserPageObject;
import com.fedex.rlog.automation.pages.commons.BaseRlogLoginPageObject;
import com.fedex.rlog.automation.utils.Config;
import com.fedex.rlog.automation.utils.DataBaseUtil;
import com.fedex.rlog.automation.utils.Driver;
import com.fedex.rlog.automation.utils.SeleniumTestHelper;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class A_UserStepDefinition extends CommonStepDefinition {

	WebDriver driver;
	String Query;
	String Actual;
	String Expected;
	public String dirPath = System.getProperty("user.dir");
	public  String jsonFilePath = dirPath + "/src/test/resources/" +"order.json";
	BaseRlogLoginPageObject baseCommerceLoginPageObject = new BaseRlogLoginPageObject();
	DataBaseUtil dataBaseUtil=new DataBaseUtil();
	UserPageObject userPageObject=new UserPageObject();
	List<String> PortalcolumnData = new ArrayList<>();
	List<String> DBcolumnData = new ArrayList<>();
 
	public static int generateRandomNumber(int min, int max) {
		Random foo = new Random();
		return foo.nextInt((max + 1) - min) + min;
	}
	
	public A_UserStepDefinition() {
		this.driver = Driver.getInstance();
	}

	@Before
	public void intiate(Scenario scenario) {
			
	}

	@After
	public void cleanUp(Scenario scenario) {

	}
	
	
	@Given("^User is on the home page$")
	public void user_is_on_the_home_page() throws Throwable {
		
		baseCommerceLoginPageObject.open(Config.getProperty("rlog_url"));
	    
	}
	
	@When("^user clicks on Administration$")
	public void user_clicks_on_Administration() throws Throwable {
		SeleniumTestHelper.clickOnButton(userPageObject.AdministrationMenu);  
	}
	
	@When("^user click on user screen$")
	public void user_click_on_user_screen() throws Throwable {
		SeleniumTestHelper.clickOnButton(userPageObject.UserScreen);
	}
	
	@When("^user clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {

		SeleniumTestHelper.clickOnButton(userPageObject.UserSearchButton);
	}
	
	@When("^user enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) throws Throwable {
		SeleniumTestHelper.enterTextInTextBox(userPageObject.UserNameInput,username);   
	}
	
	@Then("^user verifies error message \"([^\"]*)\"$")
	public void user_verifies_error_message(String Expected) throws Throwable {
		
		Actual=SeleniumTestHelper.getText(userPageObject.Message(Expected));
		
		SeleniumTestHelper.assertEquals(Actual, Expected);
	}
	
	@When("^user enters userid as \"([^\"]*)\"$")
	public void user_enters_userid_as(String userid) throws Throwable {
		SeleniumTestHelper.enterTextInTextBox(userPageObject.UserIDInput,userid); 
		
		
	}
	
	@When("^user clicks on list$")
	public void user_clicks_on_list() throws Throwable {
		SeleniumTestHelper.clickOnButton(userPageObject.UsernameListButton);
	}

	@When("^user selects username \"([^\"]*)\" from the list$")
	public void user_selects_username_from_the_list(String username) throws Throwable {
		SeleniumTestHelper.clickOnButton(userPageObject.UsernameLov(username));   
	}

	@Then("^user verifies the user present in the grid \"([^\"]*)\"$")
	public void user_verifies_the_user_present_in_the_grid(String username) throws Throwable {
		Expected=username;
		
		Actual=SeleniumTestHelper.getText(userPageObject.UsernameGriddataLocation);
		
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
	}
	
	@Then("^user verifies all the details of the user \"([^\"]*)\" in database$")
	public void user_verifies_all_the_details_of_the_user_in_database(String userid) throws Throwable {
	    
		Query="select * from users where usr_id='"+userid+"'";
		
		//verifying user id
		Expected=SeleniumTestHelper.getText(userPageObject.Usedidgrid(userid));
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"usr_id");
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
		//Verifying Fedexid
		Expected=SeleniumTestHelper.getText(userPageObject.Fedexidgrid(userid));
		if(Expected.equalsIgnoreCase(""))
		{
			Expected=null;
		}
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"usr_fedex_id");
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
		//verifying Emailid
		Expected=SeleniumTestHelper.getText(userPageObject.Emailidgrid(userid));
		if(Expected.equalsIgnoreCase(""))
		{
			Expected=null;
		}
		
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"usr_email");
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
		//Verifying username
		Expected=SeleniumTestHelper.getText(userPageObject.Usernamegrid(userid));
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"USR_NAME");
		
		//Verifying Contact
		Expected=SeleniumTestHelper.getText(userPageObject.Contactgrid(userid));
		if(Expected.equalsIgnoreCase(""))
		{
			Expected=null;
		}
		
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"usr_contact_number");
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
		//Verifying Active user
		Expected=SeleniumTestHelper.getText(userPageObject.Activeusergrid(userid));
		if(Expected.equalsIgnoreCase("YES"))
		{
			Expected="Y";
		}
		else {
			Expected="N";
		}
		
		Actual=DataBaseUtil.getFirstRowDataWithColumnName(Query,"usr_active");
		SeleniumTestHelper.assertEquals(Actual, Expected);
		
		
	}
	
	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String userid) throws Throwable {
		SeleniumTestHelper.clickOnButton(userPageObject.Usedidgrid(userid));
	}

	@Then("^user verifies all the user role data of \"([^\"]*)\" in database$")
	public void user_verifies_all_the_user_role_data_of_in_database(String userid) throws Throwable {
		List<WebElement> roles= driver.findElements(By.xpath("//tr[@id='userroles']/child::td[2]"));
		
		
		for(WebElement role : roles)
		{
			PortalcolumnData.add(SeleniumTestHelper.getText(role));
		}
		
		
		Collections.sort(PortalcolumnData);
		
		Query="select * from user_roles where URL_USR_ID='"+userid+"' order by url_role";
		
		DBcolumnData=DataBaseUtil.getColumnData(Query, "url_role");
		
		SeleniumTestHelper.assertTrue(PortalcolumnData.equals(DBcolumnData),"User roles are verified in DB");
		
	}
	
	@Then("^user verifies all the user Previleges data of \"([^\"]*)\" in database$")
	public void user_verifies_all_the_user_Previleges_data_of_in_database(String userid) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");

		Query = "select * from user_privs where usp_usr_id='"+userid+"'";
		
		//verifying privileges userID
		
		Expected = SeleniumTestHelper.getText(userPageObject.UserPrividGrid);
		Actual = DataBaseUtil.getFirstRowDataWithColumnName(Query, "USP_USR_ID");
		
		 SeleniumTestHelper.assertEquals(Expected, Actual, "UserPriv ID matches ");
		 
		 
		 //Verifying Customer Service		 
		 Expected = SeleniumTestHelper.getText(userPageObject.UserPrivCustomerGrid);
		 
		 Query = "select * from user_privs where usp_usr_id='"+userid+"'"+"and USP_ENC_CRV_ID='"+Expected+"'" ;
		 
			Actual = DataBaseUtil.getFirstRowDataWithColumnName(Query, "USP_ENC_CRV_ID");
			
			 SeleniumTestHelper.assertEquals(Expected, Actual, "Customer service matches");
			
		 //Verifying Source
			 
			 Expected = SeleniumTestHelper.getText(userPageObject.UserPrivSourceGrid);
			 Actual = DataBaseUtil.getFirstRowDataWithColumnName(Query, "USP_ENC_SRC_ID");
				
				 SeleniumTestHelper.assertEquals(Expected, Actual, "Source matches");
			
				 
				//Verifying Warehouse
				 
				 Expected = SeleniumTestHelper.getText(userPageObject.UserPrivWarehouseGrid);
				 if(Expected.equalsIgnoreCase("Roadmap Facility"))
				 {
					 Expected ="008";
				 }
				 
				 Actual = DataBaseUtil.getFirstRowDataWithColumnName(Query, "USP_ENC_WHS_ID");
				 SeleniumTestHelper.assertEquals(Expected, Actual, "Warehouse matches");
	}
	


	
}
