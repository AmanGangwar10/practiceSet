package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	   //initialization
	
		public CreateProductPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
	   //Declaration

		@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
		private WebElement productPlusSign;
		
		@FindBy(name = "productname")
		private WebElement productName;
		
		@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
		private WebElement saveButton;
		
	   //getterMethods
		
		public WebElement getCreateProductImg() {
			return productPlusSign;
		}

		public WebElement getProductName() {
			return productName;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		//Business logics
		
		/**
		 * This method is used to click on + sign
		 * @author hp
		 */
		
		public void ClickProdPlusSign()
		{
			productPlusSign.click();
		}
		
		/**
		 * This method is used to enter product name
		 * @param ProdName
		 * @author hp
		 */

		public void enterProdName(String ProdName)
		{
			productName.sendKeys(ProdName);
		}
		
		/**
		 * This Method is used to click on save Button
		 * @author hp
		 */
		
		public void clickOnSaveButton()
		{
			saveButton.click();
		}
		
}