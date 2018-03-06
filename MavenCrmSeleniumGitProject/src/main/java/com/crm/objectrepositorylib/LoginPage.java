package com.crm.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.WebdriverCommonLib;

public class LoginPage extends WebdriverCommonLib{
	
	@FindBy(name="user_name")
	WebElement userNameEdt;
	
	@FindBy(name="user_password")
	WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	WebElement loginBtn;
	
	public void login(String userName,String password) throws Throwable
	{
		waitForElement(userNameEdt);
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
