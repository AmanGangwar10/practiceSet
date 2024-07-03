package Generric_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	/**
	 * this method is used for maximizing window
	 * @param driver
	 * @author hp
	 */
	
	public void maximizeWindow(WebDriver driver) 
	{	
		driver.manage().window().maximize();	
	}
	
	/**
	 * this method is used to wait all elements to get loaded in GUI
	 * @param driver
	 * @author hp
	 */
	
	public void waitForElementToLoad(WebDriver driver) 
	{	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	
	/**
	 * this method is used to switch the windows
	 * @param driver
	 * @author hp
	 */
		
	public void switchingWindows(WebDriver driver,String particalText)
	{
		 Set<String> wins = driver.getWindowHandles();
	        Iterator<String> it = wins.iterator();
	        while(it.hasNext())
	         {
	    	   String win = it.next();
	    	   driver.switchTo().window(win);
	    	   String currentTitle = driver.getTitle();
	    	    if(currentTitle.contains(particalText))
	    	     {
	    		   break;
	    	     }
	        }
	      
	}
	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 * @author hp
	 */
	
	        public void alertAccept(WebDriver driver)
	        {
	        	driver.switchTo().alert().accept();
	        }
	        
	       /**
	        *This method is used to dismiss the alert popup  
	        * @param driver
	        * @author hp
	        */

	        public void alertDismiss(WebDriver driver)
	        {
	        	driver.switchTo().alert().dismiss();
	        } 
		
	        /**
	         * This method is used to handle drop down using Select class(selectByIndex)
	         * @param ele
	         * @param value
	         * @author hp
	         */
	        
	        public void selectByIndexApproach(WebElement ele ,int value)
	        {
	        	Select select = new Select(ele);
	        	select.selectByIndex(value);
	        }
	        
	        /**
	         * This method is used to handle drop down using Select class(selectByValue)
	         * @param ele
	         * @param value
	         * @author hp
	         */
	        
	        public void selectByValueApproach(WebElement ele ,String value)
	        {
	        	Select select = new Select(ele);
	        	select.selectByValue(value);
	        }
	        
	        /**
	         * This method is used to handle drop down using Select class(selectByVisibleText)
	         * @param ele
	         * @param value
	         * @author hp
	         */
	        
	        public void selectByVisibleTextApproach(WebElement ele ,String text)
	        {
	        	Select select = new Select(ele);
	        	select.selectByVisibleText(text);
	        }
	        
	        /**
	    	 * This method is used to move the cursor to a particular element
	    	 * @param driver
	    	 * @param ele
	    	 * @author hp
	    	 */
	        
	        public void moveToElement(WebDriver driver,WebElement ele)
	        {
	        	Actions act = new Actions(driver);
	        	act.moveToElement(ele).perform();
	        }
	        
	        /**
	         * this method is used to take a screenshot if the script are running the failed
	         * @param driver
	         * @param screenShotName
	         * @return
	         * @throws Throwable
	         * @author hp
	         */
	        
	        public static String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
	        {
	        	TakesScreenshot tss = (TakesScreenshot)driver;
	        	File src = tss.getScreenshotAs(OutputType.FILE);
	        	File dst = new File("./ScreenShots/" + screenShotName + ".png");
	        	FileUtils.copyFile(src, dst);
	        	return dst.getAbsolutePath();
	        }
	
	        
 }