/*package com.crm.organizationtest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.CommonUtils;
import com.crm.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.objectrepositorylib.HomePage;
import com.crm.objectrepositorylib.OrganizationInfomationPage;
import com.crm.objectrepositorylib.OrganizationPage;

public class OrganizationTest extends BaseClass{
	
	@Test(groups="SmokeTest")
	public void createOrganizationTest() throws Throwable{
	
		Reporter.log("read test data from excel",true);
		String organizationName=CommonUtils.getExcelData("testData", 4, 3)+ran.nextInt();
		
		Reporter.log("navigate to organization page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to create organization page",true);
		OrganizationPage op=PageFactory.initElements(driver, OrganizationPage.class);
		op.navigateToCreateOrganization();
		
		Reporter.log("navigate to save",true);
		CreateNewOrganizationPage cno=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		cno.navigateToSave(organizationName);
		
		Reporter.log("navigate to organization information",true);
		OrganizationInfomationPage oip=PageFactory.initElements(driver, OrganizationInfomationPage.class);
		String actOrgName=oip.getOrganizationName().getText().trim();
		
		Reporter.log("verifying organization name",true);
		Assert.assertEquals(actOrgName, organizationName);
		
		CommonUtils.setExcelData("testData", 4, 13, "Pass");
	}
	
	@Test(groups="RegressionTest")
	public void createOrganizationWithOrganizationTypeTest() throws Throwable{
				
		Reporter.log("read test data from excel",true);
		String organizationName=CommonUtils.getExcelData("testData", 5, 3)+ran.nextInt();
		String orgType=CommonUtils.getExcelData("testData", 5, 4);
		
		Reporter.log("navigate to organization page",true);
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOrganizationsLink();
		
		Reporter.log("navigate to create organization page",true);
		OrganizationPage op=PageFactory.initElements(driver, OrganizationPage.class);
		op.navigateToCreateOrganization();
		
		Reporter.log("navigate to save",true);
		CreateNewOrganizationPage cno=PageFactory.initElements(driver, CreateNewOrganizationPage.class);
		cno.navigateToSave(organizationName, orgType);
		
		Reporter.log("navigate to organization information",true);
		OrganizationInfomationPage oip=PageFactory.initElements(driver, OrganizationInfomationPage.class);
		String actOrgName=oip.getOrganizationName().getText().trim();
		String actType=oip.getOrganizationType().getText().trim();
		
		Reporter.log("verifying org name",true);
		sAssert.assertEquals(actOrgName, organizationName);
		
		Reporter.log("verifying org type",true);
		sAssert.assertEquals(actType, orgType);
		
		CommonUtils.setExcelData("testData", 5, 13, "Pass");
		sAssert.assertAll();
	}

}
*/