package Practice;

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

import Generric_Utilities.Excel_Utility;
import Generric_Utilities.File_Utility;
import Generric_Utilities.Java_Utility;
import Generric_Utilities.WebDriver_Utility;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class Create_campaign_with_product {

public static void main(String[] args) throws Throwable {
		
//		WebDriver driver = new ChromeDriver();
		
//		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\FileCommonDataVtiger.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("user-name");
//		String PASSWORD = pro.getProperty("password");
		
		File_Utility flib = new File_Utility();
		String URL = flib.getkeyAndValueData("url");
		String USERNAME = flib.getkeyAndValueData("user-name");
		String PASSWORD = flib.getkeyAndValueData("password");
		
		WebDriver driver;
		String BROWSER = flib.getkeyAndValueData("browser");
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else
		{
			driver = new ChromeDriver();
		}
		
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForElementToLoad(driver);
	
	 // driver.get("http://localhost:8888/");	
		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
	//  VtigerLoginPage (Pom Class Implementation)	
//		VtigerLoginPage login = new VtigerLoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.linkText("Products")).click();
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
	//	Random rannum = new Random();
	//	int ranNum = rannum.nextInt(1000);
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandowNumber();
		
//	 // Step 1 : Path Connection	
//		FileInputStream fis2 = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
//		
//	 // Step 2 : Open Workbook in read mode
//		Workbook book = WorkbookFactory.create(fis2);
//		
//	 // Step 3 : get the control of the sheet
//		Sheet sheet = book.getSheet("Product");
//		
//	 // Step 4 : get the control of the row
//		Row row1 = sheet.getRow(0);
//		
//	 // Step 5 : get the control of the cell	
//		Cell cell1 = row1.getCell(0);
//		
//		String productData = cell1.getStringCellValue()+ranNum;
		
		Excel_Utility elib = new Excel_Utility();
//		String productData = elib.getExcelData("Product", 0, 0)+ranNum;
		String productData = elib.readExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		
		System.out.println(productData);	
		
		driver.findElement(By.name("productname")).sendKeys(productData);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
//		driver.findElement(By.linkText("More")).click();
		
		HomePage home1 = new HomePage(driver);
		home1.clickMoreLink();
		
//		driver.findElement(By.linkText("Campaigns")).click();
		
		HomePage home2 = new HomePage(driver);
		home2.clickCampaignsLink();
		
	    driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
	    
//	 // Step 1 : Path Connection	
//	 	FileInputStream fis3 = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
//	 		
//	 // Step 2 : Open Workbook in read mode
//		Workbook book1 = WorkbookFactory.create(fis3);
//	 		
//	 // Step 3 : get the control of the sheet
// 		Sheet sheet1 = book1.getSheet("Campaign");
//	 		
//	 // Step 4 : get the control of the row
// 		Row row2 = sheet1.getRow(0);
//	 		
// 	 // Step 5 : get the control of the cell	
//		Cell cell2 = row2.getCell(0);
//	 		
//		String campaignData = cell2.getStringCellValue()+ranNum;
	    
	    Excel_Utility elib1 = new Excel_Utility();
	    String campaignData = elib1.getExcelData("Campaign", 0, 0)+ranNum;
	    
	 	System.out.println(campaignData);
	    
		driver.findElement(By.name("campaignname")).sendKeys(campaignData);
	    
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
//	  Set<String> wins = driver.getWindowHandles();
//      Iterator<String> it = wins.iterator();
//      while(it.hasNext())
//       {
//  	   String win = it.next();
//  	   driver.switchTo().window(win);
//  	   String currentTitle = driver.getTitle();
//  	    if(currentTitle.contains("Products&action"))
//  	     {
//  		   break;
//  	     }
//      }
		
		wlib.switchingWindows(driver, "Products&action");
      
        driver.findElement(By.cssSelector("[name='search_text']")).sendKeys(productData);
        driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
        
        //Dynamic Xpath
        
        driver.findElement(By.xpath("//a[text()='"+productData+"']")).click();
        
//        Set<String> wins1 = driver.getWindowHandles();
//        Iterator<String> it1 = wins1.iterator();
//        while(it1.hasNext())
//        {
//        String win1 = it1.next();
//        driver.switchTo().window(win1);
//        String currentTittle1 = driver.getTitle();
//        if(currentTittle1.contains("Campaign&action"))
//         {
//        	break;
//         }
//       }

        wlib.switchingWindows(driver, "Campaign&action");
        
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

  }
}