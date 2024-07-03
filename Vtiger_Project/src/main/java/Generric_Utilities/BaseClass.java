package Generric_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class BaseClass {

	public  static WebDriver sDriver;
	public  WebDriver driver;
    public	File_Utility flib = new File_Utility();
    public	Java_Utility jlib = new Java_Utility();
    public	Excel_Utility elib = new Excel_Utility();
    public	WebDriver_Utility wlib = new WebDriver_Utility();
	public  DataBaseUtility dlib = new DataBaseUtility();
	
	@BeforeSuite(groups = {"regressionTest","smokeTest"})
	public void beforeSuit() throws Throwable
	{
		dlib.dataBaseConnection(driver);
		System.out.println("DataBase Connection");
	} 
	
    @BeforeTest(groups = {"regressionTest","smokeTest"})        
	public void beforeTest()
	{
		System.out.println("Parallel Execution");
	}
	
 //   @Parameters("BROWSER")
    @BeforeClass(groups = {"regressionTest","smokeTest"})
	public void beforeClass(/*String BROWSER*/) throws Throwable
	{
    	String BROWSER = flib.getkeyAndValueData("browser");
    	
    	//Reading from CMD
   //	String BROWSER = System.getProperty("browser");
    	if(BROWSER.equals("chrome"))
    	{
    		driver = new ChromeDriver();
    	}
    	
    	else if(BROWSER.equals("firefox"))
    	{
    		driver=new FirefoxDriver();
    	}
    	
    	else if(BROWSER.equals("edge"))
    	{
    		driver=new EdgeDriver();
    	}
    	
    	else
    	{
    		driver = new ChromeDriver();
    	}
    	
		System.out.println("Browser Launched");
		sDriver = driver;
	}
	
    @BeforeMethod(groups = {"regressionTest","smokeTest"})
	public void beforeMethod() throws Throwable
	{
    	String URL = flib.getkeyAndValueData("url");
    	String USERNAME = flib.getkeyAndValueData("user-name");
    	String PASSWORD = flib.getkeyAndValueData("password");
    	
    	//Reading from CMD
//    	String URL = System.getProperty("url");
//    	String USERNAME = System.getProperty("user-name");
//    	String PASSWORD = System.getProperty("password");
    	
    	wlib.maximizeWindow(driver);
    	wlib.waitForElementToLoad(driver);
    	
    	driver.get(URL);
    	VtigerLoginPage login = new VtigerLoginPage(driver);
    	login.loginToApp(USERNAME, PASSWORD);
    	
		System.out.println("Login To Application");
	}
    
    @AfterMethod(groups = {"regressionTest","smokeTest"})
    public void afterMethod()
	{
    	HomePage home = new HomePage(driver);
    	home.logOut(driver);
		System.out.println("Logout From Application");
	} 
	
    @AfterClass(groups = {"regressionTest","smokeTest"})        
	public void afterClass()
	{
    	driver.quit();
		System.out.println("Close Browser");
	}
	
    @AfterTest(groups = {"regressionTest","smokeTest"})
	public void afterTest()
	{
		System.out.println("Parallel Execution Done");
	}
	
    @AfterSuite(groups = {"regressionTest","smokeTest"})
	public void afterSuit() throws Throwable
	{
    	dlib.dataBaseClose();
		System.out.println("Close DataBase");
	}
    
}