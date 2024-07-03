package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fetching_Data_From_Properties_File {

	public static void main(String[] args) throws Throwable {
		
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
     
      
     // HardCoding
    /*  driver.get("https://www.saucedemo.com/v1/");
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
      driver.findElement(By.id("login-button")).click(); */
		
	//Fetching Data From Properties File
      
    // Step 1 : get the java representation object of the physical file
      FileInputStream fis = new FileInputStream("./src\\test\\resources\\FileCommonData.properties");
      
      Properties pro = new Properties();
      pro.load(fis);
      
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