package com.crm.contacttest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.CommonUtils;
import com.crm.objectrepositorylib.ContactInformationPage;
import com.crm.objectrepositorylib.ContactsPage;
import com.crm.objectrepositorylib.CreateNewContactPage;
import com.crm.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.objectrepositorylib.HomePage;
import com.crm.objectrepositorylib.OrganizationPage;

public class ContactTest extends BaseClass{

	@Test(groups="SmokeTest")
	public void createContactTest() throws Throwable{
	
		Reporter.log("read test data from excel",true);
		String contactName=CommonUtils.getExcelData("testData", 1, 2);
		
		Reporter.log("navigate to contacts page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToContactLink();
		
		Reporter.log("navigate to create contact page",true);
		ContactsPage cp=PageFactory.initElements(driver, ContactsPage.class);
		cp.navigateToCreateContact();
		
		Reporter.log("navigate to save",true);
		CreateNewContactPage cnp=PageFactory.initElements(driver, CreateNewContactPage.class);
		cnp.navigateTosave(contactName);
		
		Reporter.log("capture actuval contact name",true);
		ContactInformationPage cip=PageFactory.initElements(driver, ContactInformationPage.class);
		String actName=cip.getLastNameInfo().getText().trim();
				
		Reporter.log("verifying contact name",true);
		Assert.assertEquals(actName, contactName);
		
		CommonUtils.setExcelData("testData", 1, 13, "Pass");
	}
	
	@Test(groups="RegressionTest")
	public void createContactWithImageTest() throws Throwable{
		
		Reporter.log("read test data from excel",true);
		String contactName=CommonUtils.getExcelData("testData", 3, 2);
		String imagePath=CommonUtils.getExcelData("testData", 3, 7);
		
		Reporter.log("navigate to contacts page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToContactLink();
		
		Reporter.log("navigate to create contact page",true);
		ContactsPage cp=PageFactory.initElements(driver, ContactsPage.class);
		cp.navigateToCreateContact();
		
		Reporter.log("navigate to save",true);
		CreateNewContactPage cnp=PageFactory.initElements(driver, CreateNewContactPage.class);
		cnp.navigateToSave(contactName, imagePath);
		
		Reporter.log("capture the data from contactInformation page",true);
		ContactInformationPage cip=PageFactory.initElements(driver, ContactInformationPage.class);
		String actName=cip.getLastNameInfo().getText().trim();
		
		boolean actImg=false;
		try
		{
			actImg=cip.getContactImageInfo().isDisplayed();
		}
		catch(Throwable t)
		{
		}
		
		Reporter.log("verifying contact name",true);
		Assert.assertEquals(contactName, actName);
		
		Reporter.log("verifying image",true);
		sAssert.assertTrue(actImg, "");
		
		CommonUtils.setExcelData("testData", 3, 13, "Pass");
		sAssert.assertAll();
	}
	
	@Test(groups="RegressionTest")
	public void createContactWithOrganizationTest() throws Throwable{
		
		Reporter.log("read test data from excel",true);
		String contactName=CommonUtils.getExcelData("testData", 2, 2);
		String organizationName=CommonUtils.getExcelData("testData", 2, 3)+ran.nextInt();
		
		Reporter.log("navigate to organization page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to create organization page",true);
		OrganizationPage op=PageFactory.initElements(driver, OrganizationPage.class);
		op.navigateToCreateOrganization();
		
		Reporter.log("navigate to save",true);
		CreateNewOrganizationPage cno=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		cno.navigateToSave(organizationName);
		
		Reporter.log("navigate to contacts page",true);
		hp.navigateToContactLink();
		
		Reporter.log("navigate to create contact page",true);
		ContactsPage cp=PageFactory.initElements(driver, ContactsPage.class);
		cp.navigateToCreateContact();
		
		Reporter.log("navigate to save",true);
		CreateNewContactPage cnp=PageFactory.initElements(driver, CreateNewContactPage.class);
		cnp.navigateTosave(contactName, organizationName);
		
		Reporter.log("capture the data from contactInformation page",true);
		ContactInformationPage cip=PageFactory.initElements(driver, ContactInformationPage.class);
		String actName=cip.getLastNameInfo().getText().trim();
		String actOrgName=cip.getOrganizationInfo().getText().trim();
						
		Reporter.log("verifying contact name",true);
		Assert.assertEquals(actName, contactName);
	
		Reporter.log("verifying Organization name",true);
		sAssert.assertEquals(actOrgName, organizationName);
		
		CommonUtils.setExcelData("testData", 2, 13, "Pass");
		sAssert.assertAll();
	}

}
