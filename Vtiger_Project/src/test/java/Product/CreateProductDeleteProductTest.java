package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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

import Generric_Utilities.BaseClass;
import Generric_Utilities.Excel_Utility;
import Generric_Utilities.File_Utility;
import Generric_Utilities.Java_Utility;
import Generric_Utilities.WebDriver_Utility;
import objectRepository.CreateProductPage;
import objectRepository.DeletePrdValidationPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

@Listeners(Generric_Utilities.ListenerImplementation.class)
public class CreateProductDeleteProductTest extends BaseClass {

//	    @Test(groups = {"regressionTest","smokeTest"}) 
	    @Test(retryAnalyzer = Generric_Utilities.RetryImplementation.class)
        public void CreateProductDeleteProductTest() throws Throwable {
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.ClickProdPlusSign();
		int ranNum = jlib.getRandowNumber();
		
	//	Assert.assertEquals(false, true);
		
	    String productData = elib.readExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
	    System.out.println(productData);	
	    prodPage.enterProdName(productData);
	    prodPage.clickOnSaveButton();
	    home.clickProductLink();
	    DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);
	    prdValidate.deleteProduct(driver, productData);
	    prdValidate.clickOnDeleteButton();
	    wlib.alertAccept(driver);
	    prdValidate.validateProductDeleted(driver, productData);
	    
	//    Assert.fail();
	    
        Thread.sleep(2000);
		
  }
}