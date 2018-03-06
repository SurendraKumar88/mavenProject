package com.crm.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebdriverCommonLib;

public class HomePage extends WebdriverCommonLib{
	
	@FindBy(linkText="Contacts")
	WebElement contactLink;
	public void navigateToContactLink() throws Throwable
	{
		waitForElement(contactLink);
		contactLink.click();
	}
	
	@FindBy(linkText="Organizations")
	WebElement OrganizationsLink;
	public void navigateToOrganizationsLink() throws Throwable
	{
		waitForElement(OrganizationsLink);
		OrganizationsLink.click();
	}
	
	@FindBy(linkText="Opportunities")
	WebElement OpportunitiesLink;
	public void navigateToOpportunitiesLink() throws Throwable
	{
		waitForElement(OpportunitiesLink);
		OpportunitiesLink.click();
	}
	
	@FindBy(xpath="//a[text()='More']")
	WebElement moreLink;
	public void navigateToMore() throws Throwable
	{
		waitForElement(moreLink);
		mouseMovement(moreLink);
	}
	
	@FindBy(linkText="Campaigns")
	WebElement campaignsLink;
	public void navigateToCampaignsLink() throws Throwable
	{
		waitForElement(campaignsLink);
		campaignsLink.click();
	}
	
	public void clickOnAnyLink(String linkName)
	{
		BaseClass.driver.findElement(By.linkText(linkName)).click();
	}
}
