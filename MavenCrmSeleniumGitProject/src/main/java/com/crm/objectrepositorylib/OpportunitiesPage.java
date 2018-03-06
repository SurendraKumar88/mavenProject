package com.crm.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebdriverCommonLib;

public class OpportunitiesPage extends WebdriverCommonLib{

	@FindBy(xpath="//img[@title='Create Opportunity...']")
	WebElement createOpportunityBtn;
	public void navigateToCreateOpportunity()
	{
		createOpportunityBtn.click();
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
