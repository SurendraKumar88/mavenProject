package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class ContactInformationPage extends WebdriverCommonLib {

	@FindBy(xpath="//td[text()='Last Name']/following-sibling::td[1]")
	private WebElement LastNameInfo;
	
	@FindBy(xpath="//td[text()='Organization Name']/following-sibling::td[1]")
	private WebElement organizationInfo;
	
	@FindBy(xpath="//img[@title='Contact Image']")
	private WebElement contactImageInfo;

	public WebElement getLastNameInfo() {
		return LastNameInfo;
	}

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getContactImageInfo() {
		return contactImageInfo;
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	WebElement deleteBtn;
	
	public void navigateToDelete()
	{
		deleteBtn.click();
		handleAlert();
	}
}
