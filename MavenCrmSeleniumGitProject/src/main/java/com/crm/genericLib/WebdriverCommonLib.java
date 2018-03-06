package com.crm.genericLib;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author Surendra
 *
 */
public class WebdriverCommonLib {
	
/**
 * 	
 * @param element
 * used to wait for element load
 * @throws Throwable 
 */
	public void waitForElement(WebElement element) throws Throwable
	{
		int wait=0;
		while(wait<40)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable t)
			{
				Thread.sleep(1000);	
				wait++;
			}
		}
	}
	
/**
 * used to wait for page load
 */
	public void waitForPageLoad()
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
/**
 * 
 * @param element
 * used to work with mouse movement operations "moveToElement" method from Actions class
 */
	public void mouseMovement(WebElement element)
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	
/**
 * 	
 * @param element, visibleText
 * used to work with drop down "selectByVisibleText" method from Select class
 */
	public void dropDownVisibleText(WebElement element,String visibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
/**
 * used to work with new window	
 */
	public static String parentId="";
	public void swithTOChildWindow()
	{
		Set<String> set=BaseClass.driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		parentId=it.next();
		String childId=it.next();
		
		BaseClass.driver.switchTo().window(childId);
	}
	
/**
 * used to switch back to parent window
 */
	public void swithBackToParentId()
	{
		BaseClass.driver.switchTo().window(parentId);
	}
	
/**
 * used to handle alert pop-up
 */
	public void handleAlert()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	
/**
 * 
 * @param imagePath
 * @throws Throwable
 * used to upload the file
 */
	public void fileUpload(String imagePath) throws Throwable
	{
		StringSelection Path=new StringSelection(imagePath);
		Toolkit tool=Toolkit.getDefaultToolkit();
		Clipboard mouse=tool.getSystemClipboard();
		mouse.setContents(Path, null);
		Robot r=new Robot();
		Thread.sleep(5000);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
/**
 * 	
 * @param nameOfTheLink
 * used to click on name of the any link
 */
	public void clickOnAnyLink(String nameOfTheLink)
	{
		BaseClass.driver.findElement(By.linkText(nameOfTheLink)).click();
	}
}
