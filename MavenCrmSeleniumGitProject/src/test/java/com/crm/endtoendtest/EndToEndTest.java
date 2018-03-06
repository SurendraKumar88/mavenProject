package com.crm.endtoendtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.CommonUtils;
import com.crm.objectrepositorylib.CampaignsPage;
import com.crm.objectrepositorylib.ContactInformationPage;
import com.crm.objectrepositorylib.ContactsPage;
import com.crm.objectrepositorylib.CreateNewCampaignsPage;
import com.crm.objectrepositorylib.CreateNewContactPage;
import com.crm.objectrepositorylib.CreateNewOpportunitiesPage;
import com.crm.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.objectrepositorylib.HomePage;
import com.crm.objectrepositorylib.OpportunitiesInformationPage;
import com.crm.objectrepositorylib.OpportunitiesPage;
import com.crm.objectrepositorylib.OrganizationInfomationPage;
import com.crm.objectrepositorylib.OrganizationPage;

public class EndToEndTest extends BaseClass{
	
	@Test(groups="RegressionTest")
	public void createOpertunityUsingOrgCompaignTest() throws Throwable{
		
		Reporter.log("read test data from excel",true);
		String organizationName=CommonUtils.getExcelData("testData", 6, 3)+ran.nextInt();
		String campaignName=CommonUtils.getExcelData("testData", 6, 5)+ran.nextInt();
		String oppertunityName=CommonUtils.getExcelData("testData", 6, 6)+ran.nextInt();
			
		Reporter.log("navigate to organization page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to create organization page",true);
		OrganizationPage op=PageFactory.initElements(driver, OrganizationPage.class);
		op.navigateToCreateOrganization();
		
		Reporter.log("navigate to save",true);
		CreateNewOrganizationPage cno=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		cno.navigateToSave(organizationName);
			
		Reporter.log("navigate to more page",true);
		hp.navigateToMore();
		hp.navigateToCampaignsLink();
		
		Reporter.log("navigate campaign page",true);
		CampaignsPage cgp=PageFactory.initElements(driver, CampaignsPage.class);
		cgp.navigateToCreateNewCampaing();
		
		Reporter.log("navigate to create campaign",true);
		CreateNewCampaignsPage cnp=PageFactory.initElements(driver, CreateNewCampaignsPage.class);
		cnp.navigateTosave(campaignName);
		
		Reporter.log("navigate to Opportunities name",true);
		hp.navigateToOpportunitiesLink();
		
		OpportunitiesPage opp=PageFactory.initElements(driver, OpportunitiesPage.class);
		opp.navigateToCreateOpportunity();
		
		Reporter.log("navigate to create opportunities name",true);
		CreateNewOpportunitiesPage cnop=PageFactory.initElements(driver, CreateNewOpportunitiesPage.class);
		cnop.navigateTosave(oppertunityName, organizationName, campaignName);
		
		Reporter.log("navigate to opportunities information page",true);
		OpportunitiesInformationPage opip=PageFactory.initElements(driver, OpportunitiesInformationPage.class);
		String actOraganization=opip.getOrganizationName().getText().trim();
		String actCampaign=opip.getCompaignSource().getText().trim();
		String actOpportunityName=opip.getOpportunityName().getText().trim();
		
		Reporter.log("verifying organization name",true);
		Assert.assertEquals(actOraganization, organizationName);
		
		Reporter.log("verifying Campaign name",true);
		sAssert.assertEquals(actCampaign, campaignName);
		
		Reporter.log("verifying Opportunities name",true);
		sAssert.assertEquals(actOpportunityName, oppertunityName);
		
		CommonUtils.setExcelData("testData", 6, 13, "Pass");
		sAssert.assertAll();
	}
	
	@Test(groups="RegressionTest")
	public void deleteOrgWhenOrgContainsContact_OpertunityTest() throws Throwable{
		
		Reporter.log("read test data from excel",true);
		String organizationName=CommonUtils.getExcelData("testData", 7, 3)+ran.nextInt();
		String contactName=CommonUtils.getExcelData("testData", 7, 2)+ran.nextInt();
		String oppertunityName=CommonUtils.getExcelData("testData", 7, 6)+ran.nextInt();
				
		Reporter.log("navigate to organization page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to create organization page",true);
		OrganizationPage op=PageFactory.initElements(driver, OrganizationPage.class);
		op.navigateToCreateOrganization();
		
		Reporter.log("navigate to save",true);
		CreateNewOrganizationPage cno=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		cno.navigateToSave(organizationName);
		
		Reporter.log("navigate to contact page",true);
		hp.navigateToContactLink();
		
		Reporter.log("navigate to create new contact page",true);
		ContactsPage cp=PageFactory.initElements(driver, ContactsPage.class);
		cp.navigateToCreateContact();
		
		Reporter.log("navigate to save",true);
		CreateNewContactPage cnp=PageFactory.initElements(driver, CreateNewContactPage.class);
		cnp.navigateTosave(contactName, organizationName);
		
		Reporter.log("navigate to opportunity page",true);
		hp.navigateToOpportunitiesLink();
		
		Reporter.log("navigate to create new opportunity page",true);
		OpportunitiesPage opp=PageFactory.initElements(driver, OpportunitiesPage.class);
		opp.navigateToCreateOpportunity();
		
		Reporter.log("navigate to save with organization page",true);
		CreateNewOpportunitiesPage cnop=PageFactory.initElements(driver, CreateNewOpportunitiesPage.class);
		cnop.navigateTosave(oppertunityName, organizationName);
		
		Reporter.log("navigate to organization page for delete",true);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to search organization",true);
		op.navigateToSearchWithPopup(organizationName, "Organization Name");
		
		Reporter.log("navigate to click on organization name",true);
		op.clickOnAnyLink(organizationName);
		
		Reporter.log("navigate to organization information page",true);
		OrganizationInfomationPage oip=PageFactory.initElements(driver, OrganizationInfomationPage.class);
		oip.navigateToDelete();
		
		Reporter.log("navigate to contact page",true);
		hp.navigateToContactLink();
		
		Reporter.log("navigate to search contact name",true);
		cp.navigateToSearchWithPopup(contactName, "Last Name");
		
		Reporter.log("navigate to click on contact name",true);
		cp.clickOnAnyLink(contactName);
		
		Reporter.log("navigate to contact information page",true);
		ContactInformationPage cip=PageFactory.initElements(driver, ContactInformationPage.class);
		String actOrganization=cip.getOrganizationInfo().getText().trim();
		
		Reporter.log("veritying organization name in contacts",true);
		sAssert.assertNotEquals(actOrganization, organizationName);
		
		Reporter.log("navigate to opportunity page",true);
		hp.navigateToOpportunitiesLink();
		
		Reporter.log("navigate to search opportunity name",true);
		opp.navigateToSearch(oppertunityName, "Opportunity Name");
		
		Reporter.log("navigate to verity opportunity name",true);
		boolean actOpportunityName=false;
		try
		{
			actOpportunityName=BaseClass.driver.findElement(By.linkText(oppertunityName)).isDisplayed();
		}catch(Throwable t)
		{
		}
		
		Reporter.log("verifying opportunity name",true);
		sAssert.assertFalse(actOpportunityName, "");
		
		CommonUtils.setExcelData("testData", 6, 13, "Pass");
		sAssert.assertAll();
	}
}
