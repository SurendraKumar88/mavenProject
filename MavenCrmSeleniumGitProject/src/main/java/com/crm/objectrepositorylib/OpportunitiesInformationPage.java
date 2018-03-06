package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class OpportunitiesInformationPage extends WebdriverCommonLib{

	@FindBy(xpath="//td[text()='Related To']/following-sibling::td[1]")
	private WebElement organizationNameTbx;
	
	@FindBy(xpath="//td[text()='Opportunity Name']/following-sibling::td[1]")
	private WebElement opportunitiesNameTbx;
	
	@FindBy(xpath="//td[text()='Campaign Source']/following-sibling::td[1]")
	private WebElement compaignSourceTbx;
	
	
	public WebElement getOpportunityName()
	{
		return opportunitiesNameTbx;
	}
	public WebElement getOrganizationName()
	{
		return organizationNameTbx;
	}
	public WebElement getCompaignSource()
	{
		return compaignSourceTbx;
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	WebElement deleteBtn;
	
	public void navigateToDelete()
	{
		deleteBtn.click();
		handleAlert();
	}
}
