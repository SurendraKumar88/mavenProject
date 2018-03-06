package com.crm.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.WebdriverCommonLib;

public class CreateNewOpportunitiesPage extends WebdriverCommonLib{

	@FindBy(name="potentialname")
	WebElement opportunityNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement savaBtn;
	public void navigateToSave(String opportunityName)
	{
		opportunityNameEdt.sendKeys(opportunityName);
		savaBtn.click();
	}
	
	@FindBy(xpath="//img[@tabindex='']") 
	WebElement organizationPlusSymbolBtn;
	
	@FindBy(xpath="//img[contains(@onclick,'Campaigns&action')]")
	WebElement campaignPlusSymbolBtn;
	
	
	//new window objects
		@FindBy(id="search_txt")
		WebElement newWindowFirstSearchTbx;
		
		@FindBy(name="search_field")
		WebElement newWindowDropDownSlt;
		
		@FindBy(name="search")
		WebElement newWindowSearchBtn;
		public void navigateTosave(String oppertunityName,String organizationName)
		{
			opportunityNameEdt.sendKeys(oppertunityName);
			organizationPlusSymbolBtn.click();
			
			swithTOChildWindow();
			newWindowFirstSearchTbx.sendKeys(organizationName);
			dropDownVisibleText(newWindowDropDownSlt, "Organization Name");
			newWindowSearchBtn.click();
			BaseClass.driver.findElement(By.linkText(organizationName)).click();
			swithBackToParentId();
		
			savaBtn.click();
		}
		
		public void navigateTosave(String oppertunityName,String organizationName,String campaignName)
		{
			opportunityNameEdt.sendKeys(oppertunityName);
			organizationPlusSymbolBtn.click();
			
			swithTOChildWindow();
			newWindowFirstSearchTbx.sendKeys(organizationName);
			dropDownVisibleText(newWindowDropDownSlt, "Organization Name");
			newWindowSearchBtn.click();
			BaseClass.driver.findElement(By.linkText(organizationName)).click();
			swithBackToParentId();
			
			campaignPlusSymbolBtn.click();
			
			swithTOChildWindow();
			newWindowFirstSearchTbx.sendKeys(campaignName);
			dropDownVisibleText(newWindowDropDownSlt, "Campaign Name");
			newWindowSearchBtn.click();
			BaseClass.driver.findElement(By.linkText(campaignName)).click();
			swithBackToParentId();
		
			savaBtn.click();
		}


}
