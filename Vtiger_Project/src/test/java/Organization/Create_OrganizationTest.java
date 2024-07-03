package Organization;

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
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;

@Listeners(Generric_Utilities.ListenerImplementation.class)
public class Create_OrganizationTest extends BaseClass{

//	@Test//(groups = {"regressionTest","smokeTest"})
	
	@Test(retryAnalyzer = Generric_Utilities.RetryImplementation.class)
	public void Create_OrganizationTest() throws Throwable {
		
	HomePage home = new HomePage(driver);
	home.clickOrganizationLink();
	
	CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
	orgPage.ClickOrgPlusSign();
	int ranNum = jlib.getRandowNumber();
	String organizationData = elib.readExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
	
//	Assert.assertEquals(false, true);
	
	System.out.println(organizationData);
	String phoneNum = elib.readExcelDataUsingDataFormatter("Organization", 2, 1);
	String emailID = elib.readExcelDataUsingDataFormatter("Organization", 3, 1);
	orgPage.orgData(organizationData, phoneNum, emailID);
	
//	Assert.fail();
	
	orgPage.clickOnSaveButton();
	Thread.sleep(2000);
	
//	ValidationAndVerification orgValidation = new ValidationAndVerification(driver);
//	orgValidation.orgData(driver, organizationData);
	
//	String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
	
// 	Assert.assertEquals(actData, organizationData);
// 	Assert.assertTrue(actData.contains(organizationData));
// 	Assert.assertTrue(actData.contains(organizationData),organizationData+"organization name is not verified");
	
//	SoftAssert soft = new SoftAssert();
// 	soft.assertEquals(actData, organizationData);
// 	soft.assertAll();
	
	}
}