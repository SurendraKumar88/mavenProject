package com.crm.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebdriverCommonLib;

public class CreateNewContactPage extends WebdriverCommonLib{

	@FindBy(name="lastname") 
	WebElement contactNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savaBtn;
	public void navigateTosave(String contactName)
	{
		contactNameEdt.sendKeys(contactName);
		savaBtn.click();
	}
	
	@FindBy(xpath="//img[@tabindex='']") 
	WebElement plusOrganizationBtn;
	
	//new window objects
	@FindBy(id="search_txt")
	WebElement newWindowFirstSearchTbx;
	
	@FindBy(name="search_field")
	WebElement newWindowDropDownSlt;
	
	@FindBy(name="search")
	WebElement newWindowSearchBtn;
	public void navigateTosave(String contactName,String organizationName)
	{
		contactNameEdt.sendKeys(contactName);
		plusOrganizationBtn.click();
		
		swithTOChildWindow();
		newWindowFirstSearchTbx.sendKeys(organizationName);
		dropDownVisibleText(newWindowDropDownSlt, "Organization Name");
		newWindowSearchBtn.click();
		BaseClass.driver.findElement(By.linkText(organizationName)).click();
		swithBackToParentId();
		savaBtn.click();
	}
	
	//upload photo
	@FindBy(name="imagename")
	WebElement browseBtn;
	public void navigateToSave(String contactName,String imagePath) throws Throwable
	{
		contactNameEdt.sendKeys(contactName);
		browseBtn.sendKeys(imagePath);
		savaBtn.click();
	}
	
	
}
