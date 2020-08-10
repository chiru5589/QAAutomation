package com.fedex.rlog.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fedex.rlog.automation.pages.Maintenance.CategoriesPageObject;
import com.fedex.rlog.automation.pages.Maintenance.DepartmentsPageObject;
import com.fedex.rlog.automation.utils.DataBaseUtil;
import com.fedex.rlog.automation.utils.Driver;
import com.fedex.rlog.automation.utils.SeleniumTestHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepartmentsStepDefinition {

	WebDriver driver;
	public static String randomizedDeptID;
	public static String DeptID;
	public static String Query;
	
	
	DepartmentsPageObject departmentsPageObject=new DepartmentsPageObject();
	SeleniumTestHelper seleniumTestHelper=new SeleniumTestHelper();
	CategoriesPageObject categoriesPageObject=new CategoriesPageObject();
	CategoriesStepDefinition categoriesStepDefinition=new CategoriesStepDefinition();
	DataBaseUtil dataBaseUtil=new DataBaseUtil();
	
	public DepartmentsStepDefinition() {
		this.driver = Driver.getInstance();
	}

	@Before
	public void intiate(Scenario scenario) {

	}

	@After
	public void cleanUp(Scenario scenario) {

	}
	
	public static String setDepartmentID(String DeptID) {
        randomizedDeptID = DeptID + CategoriesStepDefinition.generateRandomNumber(1111, 9999);
        CategoriesStepDefinition.DepatmentID.put(DeptID, randomizedDeptID);
        return randomizedDeptID;
	}
	public static String getDepartmentID(String DeptID) {
        randomizedDeptID = CategoriesStepDefinition.DepatmentID.get(DeptID);
        return randomizedDeptID;
	}
	
	@When("^user clicks on departments page$")
	public void user_clicks_on_departments_page() throws Throwable {
	    
		SeleniumTestHelper.clickOnButton(departmentsPageObject.DepartmentsMenu);
	}
	
	@Then("^user validates all the expected fields in the departments screen$")
	public void user_validates_all_the_expected_fields_in_the_departments_screen() throws Throwable {
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.SelectDeptId.isDisplayed(),"Department ID Dropdown "
				+ "is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.InputDeptname.isDisplayed(),"Department Name input"
				+ "is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.SelectcatId.isDisplayed(),"Category ID Dropdown "
				+ "is displayed");
		
		SeleniumTestHelper.assertTrue(categoriesPageObject.SearchButton.isDisplayed(),"Search Button is displayed");
		
		SeleniumTestHelper.assertTrue(categoriesPageObject.resetBtn.isDisplayed(),"Reset Button is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.DepartmentID.isDisplayed(),"Department ID field is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.DepartmentName.isDisplayed(),"Department Name field is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.CategoryID.isDisplayed(),"Category ID field is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.SkipClass.isDisplayed(),"Skip class field is displayed");
		
		SeleniumTestHelper.assertTrue(departmentsPageObject.Actions.isDisplayed(),"Actions field is displayed");
			    
	}
	
	@When("^User enters Department ID as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_Department_ID_as_and(String deptid, String deptname) throws Throwable {
	    
		DeptID= DepartmentsStepDefinition.setDepartmentID(deptid);		
		SeleniumTestHelper.enterTextInTextBox(departmentsPageObject.DepartmentIDinput,DeptID);
		SeleniumTestHelper.reportLog("Department ID :"+DeptID);
		
		String randomizedDeptName = deptname + CategoriesStepDefinition.generateRandomNumber(1111, 9999);
		SeleniumTestHelper.enterTextInTextBox(departmentsPageObject.DepartmentNameinput,randomizedDeptName);
		
	}

	@When("^user selects a Category \"([^\"]*)\"$")
	public void user_selects_a_Category(String catid) throws Throwable {
		
		SeleniumTestHelper.clickOnButton(departmentsPageObject.CategoryIDdropdown);
		
		SeleniumTestHelper.clickOnButton(departmentsPageObject.RandomCategory(catid));
		
		
	}

	@When("^user selects a skip class as \"([^\"]*)\"$")
	public void user_selects_a_skip_class_as(String yesorno) throws Throwable {
		
		SeleniumTestHelper.clickOnButton(departmentsPageObject.skipclass);
		
		SeleniumTestHelper.dropDownPartialItem(yesorno).click();
	    
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
	    
		SeleniumTestHelper.clickOnButton(departmentsPageObject.SaveButton);
		
	}
	
	@Then("^user verifies the newly added department in the database \"([^\"]*)\"$")
	public void user_verifies_the_newly_added_department_in_the_database(String deptid) throws Throwable {
	   
		Query="select * from departments where dep_cus_id='NIKE' and dep_id='"+DepartmentsStepDefinition.getDepartmentID(deptid)+"'";
		
		
		SeleniumTestHelper.assertTrue(DataBaseUtil.isRecordExisting(Query),"Record has been created with new Department ID");
	}
	
	@When("^user selects created \"([^\"]*)\" from department id dropdown$")
	public void user_selects_created_from_department_id_dropdown(String deptid) throws Throwable {
		
		SeleniumTestHelper.clickOnButton(departmentsPageObject.SelectDeptId);
		
		SeleniumTestHelper.dropDownPartialItem(DepartmentsStepDefinition.getDepartmentID(deptid)).click();
		
	}
	
	@When("^user updates Recovery percent as (\\d+)$")
	public void user_updates_Recovery_percent_as(int percent) throws Throwable {
		
		SeleniumTestHelper.enterTextInTextBox(departmentsPageObject.RecoveryPercentinput, String.valueOf(percent));
	    
	}
	
	@Then("^user verifies that the department record has been deleted from the database \"([^\"]*)\"$")
	public void user_verifies_that_the_department_record_has_been_deleted_from_the_database(String deptid) throws Throwable {
	    
		Query="select * from departments where dep_cus_id='NIKE' and dep_id='"+DepartmentsStepDefinition.getDepartmentID(deptid)+"'";
		
		
		SeleniumTestHelper.assertTrue(DataBaseUtil.isRecordExisting(Query),"Record has been deleted");
		
	}

}
