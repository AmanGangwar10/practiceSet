package Practice;

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

import Generric_Utilities.Excel_Utility;
import Generric_Utilities.File_Utility;
import Generric_Utilities.Java_Utility;
import Generric_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class Create_organization {


	public static void main(String[] args) throws Throwable {
		
//	WebDriver driver = new ChromeDriver();
	
//	FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\FileCommonDataVtiger.properties");
//	Properties pro = new Properties();
//	pro.load(fis);
//	
//	String URL = pro.getProperty("url");
//	String USERNAME = pro.getProperty("user-name");
//	String PASSWORD = pro.getProperty("password");
	
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
	
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.maximizeWindow(driver);
	wlib.waitForElementToLoad(driver);
	
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
 // driver.get("http://localhost:8888/");	
	driver.get(URL);
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
//  VtigerLoginPage (Pom Class Implementation)	
//	VtigerLoginPage login = new VtigerLoginPage(driver);
//	login.getUserTextField().sendKeys(USERNAME);
//	login.getPasswordTextField().sendKeys(PASSWORD);
//	login.getLoginButton().click();
	
	VtigerLoginPage login = new VtigerLoginPage(driver);
	login.loginToApp(USERNAME, PASSWORD);
	
//	driver.findElement(By.linkText("Organizations")).click();
	
	HomePage home = new HomePage(driver);
	home.clickOrganizationLink();
	
//	driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
	
	CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
	orgPage.ClickOrgPlusSign();
	
//  Random rannum = new Random();
//	int ranNum = rannum.nextInt(1000);
	
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandowNumber();
	
// // Step 1 : Path Connection	
//	FileInputStream fis2 = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Vtiger_Project\\src\\test\\resources\\ExcelSheet01.xlsx");
//	
// // Step 2 : Open Workbook in read mode
//	Workbook book = WorkbookFactory.create(fis2);
//	
// // Step 3 : get the control of the sheet
//	Sheet sheet = book.getSheet("Organization");
//	
// // Step 4 : get the control of the row
//	Row row1 = sheet.getRow(0);
//	
// // Step 5 : get the control of the cell	
//	Cell cell1 = row1.getCell(0);
//	
//	String organizationData = cell1.getStringCellValue()+ranNum;
	
	Excel_Utility elib = new Excel_Utility();
//	String organizationData = elib.getExcelData("Organization", 0, 0)+ranNum;
	String organizationData = elib.readExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
	System.out.println(organizationData);
	
//	driver.findElement(By.name("accountname")).sendKeys(organizationData);
	
//	CreateOrganizationPage orgPage1 = new CreateOrganizationPage(driver);
//	orgPage1.enterOrgName(organizationData);
	
	String phoneNum = elib.readExcelDataUsingDataFormatter("Organization", 2, 1);
//	driver.findElement(By.name("phone")).sendKeys(phoneNum);
	
//	CreateOrganizationPage orgPage2 = new CreateOrganizationPage(driver);
//	orgPage2.enterOrgPhoneNum(phoneNum);
	
	String emailID = elib.readExcelDataUsingDataFormatter("Organization", 3, 1);
//	driver.findElement(By.name("email1")).sendKeys(emailID);
	
//	CreateOrganizationPage orgPage3 = new CreateOrganizationPage(driver);
//	orgPage3.enterOrgEmail(emailID);
	
	orgPage.orgData(organizationData, phoneNum, emailID);
	
//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	
	CreateOrganizationPage orgPage4 = new CreateOrganizationPage(driver);
	orgPage4.clickOnSaveButton();
	
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
//	home.logOutfromApp();
	home.logOut(driver);
	
	}
}