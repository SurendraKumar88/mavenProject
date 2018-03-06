package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampaignsPage {

	@FindBy(name="campaignname")
	WebElement campaignNameTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savaBtn;
	public void navigateTosave(String campaignName)
	{
		campaignNameTbx.sendKeys(campaignName);
		savaBtn.click();
	}
}
