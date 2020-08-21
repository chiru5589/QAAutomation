package com.fedex.rlog.automation.pages.Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fedex.rlog.automation.utils.Driver;

public class UserPageObject {
	
	WebDriver driver;
	String Dynamic;
	
	public UserPageObject() {
		
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[contains(text(),'Administration')]")
	public WebElement AdministrationMenu;
	
	@FindBy(linkText="User")
	public WebElement UserScreen;
	
	@FindBy(css="button.btn-search")
	public WebElement UserSearchButton;
	
	@FindBy(xpath="userName")
	public WebElement UserNameInput;
	
	@FindBy(id="userID")
	public WebElement UserIDInput;
	
	@FindBy(xpath="//button[contains(text(),'LIST')]")
	public WebElement UsernameListButton;
	
	@FindBy(xpath="//th[contains(text(),'Name')]/following::td[4]")
	public WebElement UsernameGriddataLocation;
	
	
	@FindBy(xpath="//tr[@id ='userprivs']/child::td[1]")
	public WebElement UserPrividGrid;
	
	@FindBy(xpath="//tr[@id ='userprivs']/child::td[2]")
	public WebElement UserPrivCustomerGrid;
	
	@FindBy(xpath="//tr[@id ='userprivs']/child::td[3]")
	public WebElement UserPrivSourceGrid;
	
	@FindBy(xpath="//tr[@id ='userprivs']/child::td[4]")
	public WebElement UserPrivWarehouseGrid;
	
	public String Message="//*[contains(text(),'<Exp>')]";
	public WebElement Message(String Expected) {
		
		Dynamic= Message.replace("<Exp>", Expected);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String UsernameLov="//span[contains(text(),'<username>')]";
	public WebElement UsernameLov(String username) {
		
		Dynamic= UsernameLov.replace("<username>", username);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Usedidgrid="//tr[@id='<username>']/child::td[1]";
	public WebElement Usedidgrid(String userid) {
		
		Dynamic = Usedidgrid.replace("<username>", userid);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Fedexidgrid="//tr[@id='<username>']/child::td[2]";
	public WebElement Fedexidgrid(String fedexid) {
		
		Dynamic = Fedexidgrid.replace("<username>", fedexid);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Emailidgrid="//tr[@id='<username>']/child::td[3]";
	public WebElement Emailidgrid(String emailid) {
		
		Dynamic = Emailidgrid.replace("<username>", emailid);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Usernamegrid="//tr[@id='<username>']/child::td[4]";
	public WebElement Usernamegrid(String username) {
		
		Dynamic = Usernamegrid.replace("<username>", username);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Contactgrid="//tr[@id='<username>']/child::td[6]";
	public WebElement Contactgrid(String contact) {
		
		Dynamic = Contactgrid.replace("<username>", contact);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	
	public String Activeusergrid="//tr[@id='<username>']/child::td[7]";
	public WebElement Activeusergrid(String Activeuser) {
		
		Dynamic = Activeusergrid.replace("<username>", Activeuser);
	
		return Driver.getInstance().findElement(By.xpath(Dynamic));	
	}
	

}
