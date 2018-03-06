package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class LogoutPage extends WebdriverCommonLib{

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	WebElement logoutIcon;
	
	@FindBy(linkText="Sign Out")
	WebElement logoutLink;
	
	public void logOut() throws Throwable
	{
		waitForElement(logoutIcon);
		logoutIcon.click();
		logoutLink.click();
	}
}
