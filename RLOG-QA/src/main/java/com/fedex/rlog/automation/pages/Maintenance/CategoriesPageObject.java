package com.fedex.rlog.automation.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fedex.rlog.automation.utils.Driver;

public class CategoriesPageObject {
	
	WebDriver driver;
	
	public CategoriesPageObject() {
		
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	
	//DropDown
	
	@FindBy(id="catId")
	public WebElement CategoryIdDropdown;
	
	@FindBy(id="catName")
	public WebElement CategoryNameDropdown;
	
	//Button
	
	@FindBy(css="button.btn-search")
	public WebElement SearchButton;
	
	@FindBy(css="button.btn-reset")
	public WebElement ResetButton;
	
	@FindBy(css="button.btn-add")
	public WebElement AddNewButton;
	
	@FindBy(xpath="//td[@class='fxg_table_action']/child::img[1]")
	public WebElement SaveImage;
	
	//input
	
	@FindBy(xpath="//input[@ng-reflect-name='catId']")
	public WebElement CatIDinput;
	
	@FindBy(xpath="//input[@ng-reflect-name='catName']")
	public WebElement CatNameinput;
	
	
	//Table data headers
	
	@FindBy(xpath="//*[contains(text(),'Cat ID')]")
	public WebElement CatID;
	
	@FindBy(xpath="//*[contains(text(),'Cat Name')]")
	public WebElement CatName;
	
	@FindBy(xpath="//*[contains(text(),'Cat Download Date')]")
	public WebElement CatDownloadDate;
	
	@FindBy(xpath="//*[contains(text(),'Cat Download Time')]")
	public WebElement CatDownloadTime;
	
	@FindBy(xpath="//*[contains(text(),'Cat Quantity')]")
	public WebElement CatQuantity;
	
	@FindBy(xpath="//*[contains(text(),'Number of Pallets')]")
	public WebElement NoOfPallets;
	
	@FindBy(xpath="//*[contains(text(),'Days')]")
	public WebElement Days;
	
	@FindBy(xpath="//*[contains(text(),'Amount')]")
	public WebElement Amount;
	
	@FindBy(xpath="//*[contains(text(),'Expiration Date')]")
	public WebElement ExpirationDateHeader;
	
	//Fields
	@FindBy(xpath="//input[@placeholder=' Enter Cat Name']")
	public WebElement catName;
	
	@FindBy(xpath="//input[@ng-reflect-name='catQty']")
	public WebElement catQuantity;	
	
	@FindBy(xpath="//input[@ng-reflect-name='catNumOfPallets']")
	public WebElement NoOfPalletsCat;
	
	@FindBy(xpath="//input[@ng-reflect-name='catDays']")
	public WebElement DaysCat;
	
	@FindBy(xpath="//input[@ng-reflect-name='catAmount']")
	public WebElement AmountCat;
	
	@FindBy(xpath="//input[@ng-reflect-name='catExpirationDate']")
	public WebElement ExpiratinDate;
	
	@FindBy(xpath="//input[@placeholder='Enter Cat Id']")
	public WebElement catIdBox;
	
	@FindBy(xpath="//td[@class='fxg_table_action']/child::*[1]")
	public WebElement addCat;
	
	@FindBy(xpath="//td[@class='fxg_table_action']/child::*[2]")
	public WebElement cancelCat;
	
	@FindBy(xpath="//button[contains(text(),' NEW ')]")
	public WebElement newBtn;
	
	@FindBy(xpath="//td[@class='fxg_table_action']/child::*[1]")
	public WebElement editBtn;
	
	@FindBy(xpath="//td[@class='fxg_table_action']/child::*[2]")
	public WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Successfully updated')]")
	public WebElement UpdateMsg;
	
	@FindBy(xpath="//input[@ng-reflect-name='catName']")
	public WebElement EditCatName;
	
	@FindBy(xpath="//div[@aria-label='Successfully deleted']")
	public WebElement deleteMsg;
	
	@FindBy(xpath="//div[@aria-label='Successfully Saved']")
	public WebElement SucessMsg;
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']")
	public WebElement ColumnFound;	
	
	@FindBy(xpath="//button[contains(text(),' RESET ')]")
	public WebElement resetBtn;
	
	@FindBy(xpath="//select[contains(@class,'dropdow')][1]")
	public WebElement selectcatId;
	
	@FindBy(xpath="//select[contains(@class,'dropdow')][2]")
	public WebElement selectcatName;
	
	@FindBy(xpath="//button[contains(text(),'SEARCH ')]")
	public WebElement searchBtn;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	public WebElement ConfirmPopUp;
}
