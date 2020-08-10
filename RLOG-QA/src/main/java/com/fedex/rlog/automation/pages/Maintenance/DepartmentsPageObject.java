package com.fedex.rlog.automation.pages.Maintenance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fedex.rlog.automation.utils.Driver;

public class DepartmentsPageObject {
	
	
WebDriver driver;
	
	public DepartmentsPageObject() {
		
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	
	//LinkText
	
	@FindBy(linkText="Department")
	public WebElement DepartmentsMenu;
	
	//Dropdown
	
	@FindBy(xpath="//*[contains(text(),'Select Department ID')]/..")
	public WebElement SelectDeptId;
	
	@FindBy(xpath="//*[contains(text(),'Select Category ID')]/..")
	public WebElement SelectcatId;
	
	@FindBy(xpath="//select[@ng-reflect-name='depCatId']")
	public WebElement CategoryIDdropdown;
	
	@FindBy(xpath="//select[@ng-reflect-name='depSkipClass']")
	public WebElement skipclass;

	//Input
	
	@FindBy(id="depName")
	public WebElement InputDeptname;
	
	@FindBy(xpath="//input[@ng-reflect-name='depId']")
	public WebElement DepartmentIDinput;
	
	@FindBy(xpath="//input[@ng-reflect-name='depName']")
	public WebElement DepartmentNameinput;
	
	@FindBy(xpath="//input[@ng-reflect-name='depRecoveryPercent']")
	public WebElement RecoveryPercentinput;
	
	//Button
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement SaveButton;
	
	//Table Headers
	
	@FindBy(xpath="//th[contains(text(),'Department ID')]")
	public WebElement DepartmentID;
	
	@FindBy(xpath="//th[contains(text(),'Department Name')]")
	public WebElement DepartmentName;
	
	@FindBy(xpath="//th[contains(text(),'Category ID')]")
	public WebElement CategoryID;
	
	@FindBy(xpath="//th[contains(text(),'Skip Class')]")
	public WebElement SkipClass;
	
	@FindBy(xpath="//th[contains(text(),'Actions')]")
	public WebElement Actions;
	
	//Dynamic
	
	public String catid="//select[@ng-reflect-name='depCatId']/child::option[contains(text(),'<CAT_ID>')][1]";
	
	public WebElement RandomCategory(String Cat) {
		String cat_id_xpath = catid.replace("<CAT_ID>", Cat);
		//driver.findElement(By.xpath(cat_id_xpath)).click();
	
		return Driver.getInstance().findElement(By.xpath(cat_id_xpath));
		
		
	}
	
}
