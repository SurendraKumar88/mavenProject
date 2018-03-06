package com.crm.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebdriverCommonLib;

public class OrganizationPage extends WebdriverCommonLib{

	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement createOrganizationBtn;
	public void navigateToCreateOrganization()
	{
		createOrganizationBtn.click();
	}
	
	@FindBy(name="search_text")
	WebElement searchForEdt;
	
	@FindBy(name="search_field")
	WebElement searchInDropDown;
	
	@FindBy(name="submit")
	WebElement searchBtn;
	public void navigateToSearch(String searchData,String dropDownVisibleText)
	{
		searchForEdt.sendKeys(searchData);
		dropDownVisibleText(searchInDropDown, dropDownVisibleText);
		searchBtn.click();
	}	
	
	public void navigateToSearchWithPopup(String searchData,String dropDownVisibleText)
	{
		searchForEdt.sendKeys(searchData);
		dropDownVisibleText(searchInDropDown, dropDownVisibleText);
		searchBtn.click();
		try
		{
			handleAlert();
		}catch(Throwable t)
		{
		}
		
	}
	
	@FindBy(xpath="//input[@value='Delete']")
	WebElement deleteBtn;
	public void navigateToDelete()
	{
		deleteBtn.click();
	}
	
	public void clickOnAnyLink(String linkName)
	{
		BaseClass.driver.findElement(By.linkText(linkName)).click();
	}
	
	
}
