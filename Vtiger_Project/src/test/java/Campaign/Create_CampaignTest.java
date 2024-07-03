package Campaign;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generric_Utilities.BaseClass;
import Generric_Utilities.Excel_Utility;
import Generric_Utilities.File_Utility;
import Generric_Utilities.Java_Utility;
import Generric_Utilities.WebDriver_Utility;
import objectRepository.CreateCampaignPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;

@Listeners(Generric_Utilities.ListenerImplementation.class)
public class Create_CampaignTest extends BaseClass{
	
	//push1
	
//	@Test(groups="smokeTest")
	@Test(retryAnalyzer = Generric_Utilities.RetryImplementation.class)
	public void Create_CampaignTest() throws Throwable {
		
		int ranNum = jlib.getRandowNumber();
		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.ClickCampPlusSign();
		
//		Assert.assertEquals(false , true);
		
	    String campaignData = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;   
	 	System.out.println(campaignData);
	 	campPage.enterCampName(campaignData);


	 	
  //  	Assert.fail();
    	
	 	campPage.clickOnSaveButton();
	 	Thread.sleep(2000);
	 	
//	    ValidationAndVerification campValidation = new ValidationAndVerification(driver);
//	    campValidation.campData(driver, campaignData);
	
//	 	String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	 	
	 	
//	 	Assert.assertEquals(actData, campaignData);
//	 	Assert.assertTrue(actData.contains(campaignData));
//	 	Assert.assertTrue(actData.contains(campaignData),campaignData+"campaign name is not verified");
	 	
//	 	SoftAssert soft = new SoftAssert();
//	 	soft.assertEquals(actData, campaignData);
//	 	soft.assertAll();
	 	
	 	
  //  	Assert.fail();
    	
	 	campPage.clickOnSaveButton();
	 	Thread.sleep(2000);
	 	
//	    ValidationAndVerification campValidation = new ValidationAndVerification(driver);
//	    campValidation.campData(driver, campaignData);
	
//	 	String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	 	
	 	
//	 	Assert.assertEquals(actData, campaignData);
//	 	Assert.assertTrue(actData.contains(campaignData));
//	 	Assert.assertTrue(actData.contains(campaignData),campaignData+"campaign name is not verified");
	 	
//	 	SoftAssert soft = new SoftAssert();
//	 	soft.assertEquals(actData, campaignData);
//	 	soft.assertAll();
	 	
	 	
  //  	Assert.fail();
    	
	 	campPage.clickOnSaveButton();
	 	Thread.sleep(2000);
	 	
//	    ValidationAndVerification campValidation = new ValidationAndVerification(driver);
//	    campValidation.campData(driver, campaignData);
	
//	 	String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
	 	
	 	
//	 	Assert.assertEquals(actData, campaignData);
//	 	Assert.assertTrue(actData.contains(campaignData));
//	 	Assert.assertTrue(actData.contains(campaignData),campaignData+"campaign name is not verified");
	 	
//	 	SoftAssert soft = new SoftAssert();
//	 	soft.assertEquals(actData, campaignData);
//	 	soft.assertAll();
	 	
  }
}