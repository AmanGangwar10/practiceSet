package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;

@Listeners(Generric_Utilities.ListenerImplementation.class)
public class Create_ProductTest extends BaseClass {

	//    @Test(groups="regressionTest")
	    
	    @Test(retryAnalyzer = Generric_Utilities.RetryImplementation.class)
        public void Create_ProductTest() throws Throwable {
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.ClickProdPlusSign();
		int ranNum = jlib.getRandowNumber();
		String productData = elib.readExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		
	//	Assert.assertEquals(false , true);
		
		System.out.println(productData);	
		prodPage.enterProdName(productData);
		
	//	Assert.fail();
		
		prodPage.clickOnSaveButton();
		Thread.sleep(2000);
//		ValidationAndVerification prodValidation = new ValidationAndVerification(driver);
//		prodValidation.prodData(driver, productData);
		
//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
		
//	 	Assert.assertEquals(actData, productData);
//	 	Assert.assertTrue(actData.contains(productData));
//	 	Assert.assertTrue(actData.contains(productData),productData+"product name is not verified");
		
//		SoftAssert soft = new SoftAssert();
//	 	soft.assertEquals(actData, productData);
//	 	soft.assertAll();
		
  }
}