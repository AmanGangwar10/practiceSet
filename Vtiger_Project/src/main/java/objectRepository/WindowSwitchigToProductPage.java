package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchigToProductPage {

	     //initialization
	
		public WindowSwitchigToProductPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		 //Declaration	
		
		@FindBy(css = "[name='search_text']")
		private WebElement productName;
		
		@FindBy(xpath = "//input[@name=\"search\"]")
		private WebElement productSearch;

		 //getterMethods
		
		public WebElement getProductName() {
			return productName;
		}

		public WebElement getProductSearch() {
			return productSearch;
		}
		
		//Business logics
		
		/**
		 * This method is used to enter product name in campaign page
		 * @author hp
		 */
		
		public void enterProductName(String prdName)
		{
			productName.sendKeys(prdName);
		}
		
		/**
		 * This method is used to enter product name in campaign page with search product name
		 * @author hp
		 */
		
		public void searchPrdName()
		{
			productSearch.click();
		}
		
		/**
		 * This method is used to write dynamic path in pom class
		 * @author hp
		 */
		
		public void prdNamePresent(WebDriver driver,String productData)
		{
			driver.findElement(By.xpath("//a[text()='"+productData+"']")).click();
		}

}