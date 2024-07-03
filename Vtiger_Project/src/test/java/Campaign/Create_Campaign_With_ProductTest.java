package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;
import objectRepository.WindowSwitchigToProductPage;

@Listeners(Generric_Utilities.ListenerImplementation.class)
public class Create_Campaign_With_ProductTest extends BaseClass {

	//    @Test(groups = {"regressionTest","smokeTest"})
	    @Test(retryAnalyzer = Generric_Utilities.RetryImplementation.class)
        public void Create_Campaign_With_ProductTest() throws Throwable {
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.ClickProdPlusSign();
		int ranNum = jlib.getRandowNumber();
		String productData = elib.readExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		System.out.println(productData);	
		prodPage.enterProdName(productData);
		prodPage.clickOnSaveButton();
		home.clickMoreLink();
		home.clickCampaignsLink();
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.ClickCampPlusSign();
	    String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNum;
	    
	//    Assert.assertEquals(false, true);
	    
	 	System.out.println(campaignData);
	 	campPage.enterCampName(campaignData);
	 	campPage.clickProductPlusSign();
		wlib.switchingWindows(driver, "Products&action");
		WindowSwitchigToProductPage campPrdPage = new WindowSwitchigToProductPage(driver);
		campPrdPage.enterProductName(productData);
		campPrdPage.searchPrdName();
		campPrdPage.prdNamePresent(driver, productData);
        wlib.switchingWindows(driver, "Campaign&action");
        
  //      Assert.fail();
        
        campPage.clickOnSaveButton();
		Thread.sleep(2000);
//		ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
//		campProdValidation.productInCamp(driver, productData);
		
//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		
//		Assert.assertEquals(actData, campaignData);
//	 	Assert.assertTrue(actData.contains(campaignData));
//	 	Assert.assertTrue(actData.contains(campaignData),campaignData+"campaign name is not verified");
		
//		SoftAssert soft = new SoftAssert();
//	 	soft.assertEquals(actData, campaignData);
//	 	soft.assertAll();

  }
}