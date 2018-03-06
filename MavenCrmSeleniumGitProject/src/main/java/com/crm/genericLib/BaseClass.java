package com.crm.genericLib;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import com.crm.objectrepositorylib.LoginPage;
import com.crm.objectrepositorylib.LogoutPage;
/**
 * @author Surendra
 * driver - WebDriver object
 * sAssert - SoftAssert object
 * ran - Random class object
 */
@Listeners(com.crm.genericLib.SampleListener.class)
public class BaseClass{
	
	public static WebDriver driver;
	public SoftAssert sAssert=new SoftAssert();
	public Random ran=new Random();
	
//	@Parameters("browser")
	@BeforeClass(groups={"SmokeTest","RegresstionTest"})
//	public void configBC(String bName) throws Throwable
	public void configBC() throws Throwable
	{	
		Properties pObj=CommonUtils.getPropertiesObj();
		String bName=pObj.getProperty("browser");
		String url=pObj.getProperty("url");
		
		if(bName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else
			if(bName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
				driver=new ChromeDriver();
			}else
				if(bName.equals("IE"))
				{
					System.setProperty("webdriver.ie.driver", "./src/main/resources/IEDriverServer.exe");
					driver=new InternetExplorerDriver();
				}
		
//		Dimension dim=new Dimension(1200, 300);
//		driver.manage().window().setSize(dim);
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@BeforeMethod(groups={"SmokeTest","RegresstionTest"})
	public void configBM() throws Throwable
	{
		
		//read common data from properties
		Properties pObj=CommonUtils.getPropertiesObj();
		String userName=pObj.getProperty("userName");
		String password=pObj.getProperty("password");
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.login(userName, password);
	}
	
	@AfterMethod(groups={"SmokeTest","RegresstionTest"})
	public void configAM() throws Throwable
	{
		LogoutPage lop=PageFactory.initElements(driver, LogoutPage.class);
		lop.logOut();
	}
	
	@AfterClass(groups={"SmokeTest","RegresstionTest"})
	public void configAC()
	{
		driver.close();
	}
}
