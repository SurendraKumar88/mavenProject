package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class CreateNewOrganizationPage extends WebdriverCommonLib{
	
	@FindBy(name="accountname")
	WebElement organizationNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savaBtn;
	public void navigateToSave(String organizationName)
	{
		organizationNameEdt.sendKeys(organizationName);
		savaBtn.click();
	}
	
	@FindBy(name="accounttype")
	WebElement typeDropDown;
	public void navigateToSave(String organizationName,String orgType)
	{
		organizationNameEdt.sendKeys(organizationName);
		dropDownVisibleText(typeDropDown, "Analyst");
		savaBtn.click();
	}
}
