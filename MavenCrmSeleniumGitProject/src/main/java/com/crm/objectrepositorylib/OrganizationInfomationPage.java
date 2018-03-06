package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class OrganizationInfomationPage extends WebdriverCommonLib{
	
	@FindBy(xpath="//td[text()='Organization Name']/following-sibling::td[1]")
	private WebElement organizationNameTbx;
	
	@FindBy(xpath="//td[text()='Type']/following-sibling::td[1]")
	private WebElement typeTbx;
	
	
	public WebElement getOrganizationType()
	{
		return typeTbx;
	}
	public WebElement getOrganizationName()
	{
		return organizationNameTbx;
	}
	
	//delete organization
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	WebElement deleteBtn;
	
	public void navigateToDelete()
	{
		deleteBtn.click();
		handleAlert();
	}
}
