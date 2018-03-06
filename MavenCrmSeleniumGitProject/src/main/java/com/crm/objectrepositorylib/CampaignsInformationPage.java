package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class CampaignsInformationPage extends WebdriverCommonLib{

	@FindBy(xpath="//td[text()='Campaign Name']/following-sibling::td[1]")
	private WebElement campaignNameTbx;
	
	public WebElement getCampaignName()
	{
		return campaignNameTbx;
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	WebElement deleteBtn;
	
	public void navigateToDelete()
	{
		deleteBtn.click();
		handleAlert();
	}
}
