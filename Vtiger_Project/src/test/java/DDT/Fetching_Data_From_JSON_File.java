package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Driver;

public class Fetching_Data_From_JSON_File {

	public static void main(String[] args) throws Throwable {
		
		File file = new File("src\\test\\resources\\JsonFile.json");
		ObjectMapper jsonData = new ObjectMapper();
		JsonNode data = jsonData.readTree(file);
		
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@class=\"btn_action\"]")).click();
		
		Thread.sleep(3000);
		driver.quit();
			
	}
}