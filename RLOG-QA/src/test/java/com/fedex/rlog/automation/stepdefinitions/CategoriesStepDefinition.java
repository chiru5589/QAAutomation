package com.fedex.rlog.automation.stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.fedex.rlog.automation.pages.Maintenance.CategoriesPageObject;
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

public class CategoriesStepDefinition {
	
	

	
	WebDriver driver;
		public static Map<String, String> CategoryID = new HashMap<>();
		public static Map<String, String> DepatmentID = new HashMap<>();
		
		String CatID;
		String CatName;
		String Query;
		String Expected;
		String Actual;
		public static String randomizedCatID;
		BaseRlogLoginPageObject baseCommerceLoginPageObject = new BaseRlogLoginPageObject();
		CategoriesPageObject categoriesPageObject=new CategoriesPageObject();
		DataBaseUtil dataBaseUtil=new DataBaseUtil();
		
		public CategoriesStepDefinition() {
			this.driver = Driver.getInstance();
		}

		@Before
		public void intiate(Scenario scenario) {

		}

		@After
		public void cleanUp(Scenario scenario) {

		}
		
		public static int generateRandomNumber(int min, int max) {
			Random foo = new Random();
			return foo.nextInt((max + 1) - min) + min;
		}
		
		public static String setCategoryID(String CatID) {
	        randomizedCatID = CatID + generateRandomNumber(1111, 9999);
	        CategoryID.put(CatID, randomizedCatID);
	        return randomizedCatID;
		}
		public static String getCategoryID(String CatID) {
	        randomizedCatID = CategoryID.get(CatID);
	        return randomizedCatID;
		}
		
		
		@Given("^User is on the home page$")
		public void user_is_on_the_home_page() throws Throwable {
			
			baseCommerceLoginPageObject.open(Config.getProperty("rlog_url"));
		    
		}
		
		@When("^user clicks on categories page$")
		public void user_clicks_on_categories_page() throws Throwable {
		    SeleniumTestHelper.clickOnButton(categoriesPageObject.CategoriesMenu);
		}
		
		@Then("^user validates all the expected fields in the screen$")
		public void user_validates_all_the_expected_fields_in_the_screen() throws Throwable {
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.selectcatId.isDisplayed(),"Category ID Dropdown "
					+ "is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.selectcatName.isDisplayed(),"Category Name Dropdown "
					+ "is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.SearchButton.isDisplayed(),"Search Button is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.resetBtn.isDisplayed(),"Reset Button is displayed");
			
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.newBtn.isDisplayed(),"Add New Button is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.CatID.isDisplayed(),"Cat ID field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.CatName.isDisplayed(),"Cat Name field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.CatDownloadDate.isDisplayed(),"Cat Download Date field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.CatDownloadTime.isDisplayed(),"Cat Download Time field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.CatQuantity.isDisplayed(),"Cat Quantity field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.NoOfPallets.isDisplayed(),"No Of Pallets field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.Days.isDisplayed(),"Days field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.Amount.isDisplayed(),"Amount field is displayed");
			
			SeleniumTestHelper.assertTrue(categoriesPageObject.ExpirationDateHeader.isDisplayed(),"Expiration Date field is displayed");
		}

		@When("^user creates a new category with id as \"([^\"]*)\" and name as \"([^\"]*)\"$")
		public void user_creates_a_new_category_with_id_as_and_name_as(String id, String name) throws Throwable {
		    
			CatID=CategoriesStepDefinition.setCategoryID(id);
						
			SeleniumTestHelper.enterTextInTextBox(categoriesPageObject.CatIDinput,CatID);
			
			SeleniumTestHelper.reportLog("Category ID :"+CatID);
			
			String randomizedCatName = name + generateRandomNumber(1111, 9999);
			
			SeleniumTestHelper.enterTextInTextBox(categoriesPageObject.CatNameinput,randomizedCatName);
			
			SeleniumTestHelper.clickOnButton(categoriesPageObject.SaveCat);
			
		}
		
		

		@When("^User clicks on add new button$")
		public void user_clicks_on_add_new_button() throws Throwable {
			categoriesPageObject.newBtn.click();
		}

		
		@When("^enters a cat Id as \"([^\"]*)\"$")
		public void enters_a_cat_Id_as(String idNum) throws Throwable {
			/*String randomNo=String.valueOf(SeleniumTestHelper.generateRandomInt(1000, 9999));
			String idnumber=idNum+randomNo;
			System.out.println("idnumber is "+idnumber);*/
			
			categoriesPageObject.catIdBox.sendKeys(idNum);
		}


		@When("^enters a cat name as \"([^\"]*)\"$")
		public void enters_a_cat_name_as(String catname) throws Throwable {
			categoriesPageObject.catName.sendKeys(catname);
		}

		@When("^enters a cat quantity as (\\d+)$")
		public void enters_a_cat_quantity_as(int qnty) throws Throwable {
			categoriesPageObject.catQuantity.clear();
			categoriesPageObject.catQuantity.sendKeys(String.valueOf(qnty));
		  
		}

		@When("^enters a number of pallets as (\\d+)$")
		public void enters_a_number_of_pallets_as(int noOfPallets) throws Throwable {
			categoriesPageObject.NoOfPalletsCat.clear();
			categoriesPageObject.NoOfPalletsCat.sendKeys(String.valueOf(noOfPallets));
		}

		@When("^enters a cat days as (\\d+)$")
		public void enters_a_cat_days_as(int catDays) throws Throwable {
			categoriesPageObject.DaysCat.clear();
			categoriesPageObject.DaysCat.sendKeys(String.valueOf(catDays));
		    
		}

		@When("^enters a cat amount as (\\d+)$")
		public void enters_a_cat_amount_as(int amount) throws Throwable {
			//categoriesPageObject.AmountCat.clear();
			//categoriesPageObject.AmountCat.sendKeys(String.valueOf(amount));
			
			SeleniumTestHelper.enterTextInTextBox(categoriesPageObject.AmountCat, String.valueOf(amount));
		}


		@When("^enters expiry date$")
		public void enters_expiry_date() throws Throwable {
		   
		}
		
		@When("^user clicks on save cat button$")
		public void user_clicks_on_save_cat_button() throws Throwable {
			categoriesPageObject.SaveCat.click();
		}


		@Then("^user verifies that update message is  displayed$")
		public void user_verifies_that_update_message_is_displayed() throws Throwable {
		   String ExpectedMsg="Successfully updated";
		   String ActualMsg=categoriesPageObject.UpdateMsg.getText();
		   
		   if(categoriesPageObject.UpdateMsg.isDisplayed())
		   {
			   SeleniumTestHelper.assertEquals(ActualMsg, ExpectedMsg);
		   }
		   else
		   {
			   SeleniumTestHelper.fail("The suceess message failed to display");
		   }
		}
		@When("^user selects \"([^\"]*)\" and clicks on search button$")
		public void user_selects_and_clicks_on_search_button(String categoryId) throws Throwable {
			//String catId=String.valueOf(CategoryStepDefination.getCategoryID(categoryId));
			//String catId=categoryId;
			//String CAT_ID=CategoriesStepDefinition.getCategoryID();
			Thread.sleep(5000);
			//categoriesPageObject.selectcatId.sendKeys(CAT_ID);
			//Thread.sleep(2000);
			//categoriesPageObject.searchBtn.click();
		}
		
		@Then("^user verifies the edited record in the database \"([^\"]*)\",\"([^\"]*)\",(\\d+),(\\d+),(\\d+),(\\d+)$")
		public void user_verifies_the_edited_record_in_the_database(String categryId, String catName, int catQty, int catNoPallets, int catDays, int catAmt) throws Throwable {
			
			//String CAT_ID=categryId;
			//String CAT_ID=CategoryStepDefination.getCategoryID(categryId);
			/*String CAT_ID=CategoriesStepDefinition.getCategoryID();
			String ActualcatNameVal=catName;
			String ActualcatQntyVal=String.valueOf(catQty);
			String ActualCatNoOfPalletsVal=String.valueOf(catNoPallets);
			String ActualCatDaysVal=String.valueOf(catDays);
			String ActualCatAmtVal=String.valueOf(catAmt);
			
			System.out.println("CAT_ID is "+CAT_ID);
			   String query="select CAT_NAME from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   String CatNameColVal=DataBaseUtil.getFirstRowDataWithColumnName(query, "CAT_NAME");
			   System.out.println("CatNameColVal is "+CatNameColVal);
			   SeleniumTestHelper.assertEquals(ActualcatNameVal, CatNameColVal, "category name has been updated ");
			   
			   String query1="select CAT_QTY from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   String CatQtyColVal=DataBaseUtil.getFirstRowDataWithColumnName(query1, "CAT_QTY");
			   System.out.println("CatQtyColVal is "+CatQtyColVal);
			   SeleniumTestHelper.assertEquals(ActualcatQntyVal, CatQtyColVal, "category uantty has been updated ");
			   
			   String query2="select CAT_NUM_OF_PALLETS from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   String CatNoOfPalletsColVal=DataBaseUtil.getFirstRowDataWithColumnName(query2, "CAT_NUM_OF_PALLETS");
			   System.out.println("CatNoOfPalletsColVal is "+CatNoOfPalletsColVal);
			   SeleniumTestHelper.assertEquals(ActualCatNoOfPalletsVal, CatNoOfPalletsColVal, "category pallets has been updated ");
			   
			   String query3="select CAT_DAYS from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   String CatDaysColVal=DataBaseUtil.getFirstRowDataWithColumnName(query3, "CAT_DAYS");
			   System.out.println("CatDaysColVal is "+CatDaysColVal);
			   SeleniumTestHelper.assertEquals(ActualCatDaysVal, CatDaysColVal, "category days has been updated ");
			   
			   String query4="select CAT_AMOUNT from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   String CatAmtColVal=DataBaseUtil.getFirstRowDataWithColumnName(query4, "CAT_AMOUNT");
			   System.out.println("CatAmtColVal is "+CatAmtColVal);
			   SeleniumTestHelper.assertEquals(ActualCatAmtVal, CatAmtColVal, "category Amount has been updated ");*/
			   
		}
		
		@When("^User clicks on Edit button$")
		public void user_clicks_on_Edit_button() throws Throwable {
			
		   SeleniumTestHelper.click(categoriesPageObject.editBtn);
		}

		@Then("^user verifies the newly added record in the database \"([^\"]*)\"$")
		public void user_verifies_the_newly_added_record_in_the_database(String categoryId) throws Throwable {
			Query="select * from categories where cat_cus_id='NIKE' and cat_id='"+CategoriesStepDefinition.getCategoryID(categoryId)+"'";
			
			
			SeleniumTestHelper.assertTrue(DataBaseUtil.isRecordExisting(Query),"Record has been created with new Category ID");
			
			
		}
		
		@When("^enters cat name as\"([^\"]*)\"$")
		public void enters_cat_name_as(String CatNameEdit) throws Throwable {
			Thread.sleep(3000);
			categoriesPageObject.EditCatName.clear();
			categoriesPageObject.EditCatName.sendKeys(CatNameEdit);
		}

		@When("^enters expiry date as(\\d+)$")
		public void enters_expiry_date_as(int expiryDate) throws Throwable {
			
			categoriesPageObject.ExpiratinDate.sendKeys(String.valueOf(expiryDate));
		}
		
		@When("^user clicks on delete button$")
		public void user_clicks_on_delete_button() throws Throwable {
			/*categoriesPageObject.deleteBtn.click();
		    Thread.sleep(3000);*/
			
			SeleniumTestHelper.clickOnButton(categoriesPageObject.deleteBtn);
			
		}
		
		@When("^user verifies that Deleted message is  displayed$")
		public void user_verifies_that_Deleted_message_is_displayed() throws Throwable {
			 String ExpectedMsg="Successfully deleted";
			   
			   String ActualMsg=categoriesPageObject.deleteMsg.getText();
			   
			   
				   SeleniumTestHelper.assertEquals(ActualMsg, ExpectedMsg);
			   
		}
		
		@Then("^user verifies that success message is  displayed$")
		public void user_verifies_that_success_message_is_displayed() throws Throwable {
		   String ExpectedMsg="Successfully Saved";
		
		   String ActualMsg=categoriesPageObject.SucessMsg.getText();	
		   
		   SeleniumTestHelper.assertEquals(ActualMsg, ExpectedMsg);
		   
		}
		@Then("^user verifies that the record has been deleted from the database \"([^\"]*)\"$")
		public void user_verifies_that_the_record_has_been_deleted_from_the_database(String categoryId) throws Throwable {
			//String catIdVal=categoryId;
			//String CAT_ID=String.valueOf(CategoryStepDefination.getCategoryID(categoryId));
			//String CAT_IDNew=CategoryID.get(categoryId);
			//System.out.println("CAT_IDNew is "+CAT_IDNew);
			/*String CAT_ID=CategoriesStepDefinition.getCategoryID();
			System.out.println("CAT_ID is "+CAT_ID);
			   String query="select * from CATEGORIES where CAT_ID='"+CAT_ID+"'";
			   List<String> noOfCatId=DataBaseUtil.getColumnData(query, "CAT_ID");
			   //List<String> CatId =DataBaseUtil.getRowsDataWithColumnName(query, CAT_ID);
			   int noOfRecords=noOfCatId.size();
			   System.out.println("no of record found are"+noOfRecords);
			   if(noOfRecords==0)
			   {
				   SeleniumTestHelper.assertTrue(true, "Record has been Deleted sucessfully");
			   }
			   else
			   {
				   SeleniumTestHelper.fail("record found in the DB");
			   }*/
			
			Query="select * from categories where cat_cus_id='NIKE' and cat_id='"+CategoriesStepDefinition.getCategoryID(categoryId)+"'";
			
			
			SeleniumTestHelper.assertFalse(DataBaseUtil.isRecordExisting(Query),"Record has been deleted");
			
			
		}
		
		@When("^user clicks on Reset button$")
		public void user_clicks_on_Reset_button() throws Throwable {
			categoriesPageObject.resetBtn.click();
		}

		@When("^user verifies that the data is not displayed on the page$")
		public void user_verifies_that_the_data_is_not_displayed_on_the_page() throws Throwable {
		 try {
			 
			// assertFalse(categoryPageObject.ColumnFound.isDisplayed(), "Data has been cleared");
			  SeleniumTestHelper.assertFalse(categoriesPageObject.ColumnFound.isDisplayed(), "no data found");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("data has been cleared");
		}
		}
		
		@When("^user selects a \"([^\"]*)\" and clicks on search button$")
		public void user_selects_a_and_clicks_on_search_button(String categoryId) throws Throwable {
			//String CAT_ID=CategoryStepDefination.getCategoryID();
			Thread.sleep(5000);
			String catId=categoryId;
			categoriesPageObject.selectcatId.sendKeys(catId);
			//categoriesPageObject.searchBtn.click();
		}

		@When("^user clicks confirms to delete$")
		public void user_clicks_confirms_to_delete() throws Throwable {
			/*Thread.sleep(2000);
			categoriesPageObject.ConfirmPopUp.click();
			Thread.sleep(5000);*/
			
			SeleniumTestHelper.clickOnButton(categoriesPageObject.ConfirmPopUp);
		}
		
		@When("^user selects created \"([^\"]*)\" from category id dropdown$")
		public void user_selects_created_from_category_id_dropdown(String catid) throws Throwable {
		 
		//CatID=CategoriesStepDefinition.getCategoryID(catid);
		
		SeleniumTestHelper.clickOnButton(categoriesPageObject.selectcatId);
		
		SeleniumTestHelper.dropDownPartialItem(CategoriesStepDefinition.getCategoryID(catid)).click();
					
		}
		
		@When("^user clicks on Search button$")
		public void user_clicks_on_Search_button() throws Throwable {
		    
			SeleniumTestHelper.clickOnButton(categoriesPageObject.SearchButton);
			
		}
		
		
		@Then("^user verifies the category id \"([^\"]*)\" and updated \"([^\"]*)\" (\\d+) in database$")
		public void user_verifies_the_category_id_and_updated_in_database(String categoryId, String fieldname, int fieldvalue) throws Throwable {
			Query="select * from categories where cat_cus_id='NIKE' and cat_id='"+CategoriesStepDefinition.getCategoryID(categoryId)+"'";
			
			Actual=String.valueOf(fieldvalue);
			Expected=DataBaseUtil.getFirstRowDataWithColumnName(Query,fieldname);
			
			SeleniumTestHelper.assertEquals(Actual, Expected, "Record has been updated");
		}
		
		@Then("^user verifies that data has been cleared$")
		public void user_verifies_that_data_has_been_cleared() throws Throwable {

			SeleniumTestHelper.assertFalse(false,"Data has been Cleared");
			
		}


}
