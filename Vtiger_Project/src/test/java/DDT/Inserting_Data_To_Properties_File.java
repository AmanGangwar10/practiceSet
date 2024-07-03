package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inserting_Data_To_Properties_File {

	public static void main(String[] args) throws Throwable {
	
	//Writing Data to property file	
	 Properties pro = new Properties();
	 pro.setProperty("user-name", "standard_user");
	 pro.setProperty("password", "secret_sauce");
	 pro.setProperty("url", "https://www.saucedemo.com/v1/");

	 FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\FileCommonData.properties");
	 pro.store(fos, "commonData");
	 System.out.println("Data written successfully");
	 
	//Read Data From Properties File
     
	    WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	 	 
	    // Step 1 : get the java representation object of the physical file
	      FileInputStream fis1 = new FileInputStream("./src\\test\\resources\\FileCommonData.properties");
	      
	      Properties pro1 = new Properties();
	      pro.load(fis1);
	      
	    //Step 3 :-
	     
	     String URL = pro.getProperty("url");
	     String USERNAME = pro.getProperty("user-name");
	     String PASSWORD = pro.getProperty("password");
	     driver.get(URL);
	 
	     driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	     driver.findElement(By.id("password")).sendKeys(PASSWORD);
	     driver.findElement(By.id("login-button")).click();
	 
	}
}