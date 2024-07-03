package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	        //initialization
	
			public CreateCampaignPage(WebDriver driver) 
			{
				PageFactory.initElements(driver, this);
			}
			
			 //Declaration

			@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
			private WebElement campaignPlusSign;
			
			@FindBy(name = "campaignname")
			private WebElement campaignName;
			
			@FindBy(xpath ="//img[@alt=\"Select\"]")
			private WebElement plusSignToNavigateProductPage;
			
			@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
			private WebElement saveButton;

			 //getterMethods
			
			public WebElement getCampaignPlusSign() {
				return campaignPlusSign;
			}

			public WebElement getCampaignName() {
				return campaignName;
			}
			
			public WebElement getPlusSignToNavigateProductPage() {
				return plusSignToNavigateProductPage;
			}

			public WebElement getSaveButton() {
				return saveButton;
			}
				
			//Business logics
			
			/**
			 * This method is used to click on + sign
			 * @author hp
			 */
			
			public void ClickCampPlusSign()
			{
				campaignPlusSign.click();
			}
			
			/**
			 * This method is used to enter campaign name
			 * @param CampName
			 * @author hp
			 */

			public void enterCampName(String CampName)
			{
				campaignName.sendKeys(CampName);
			}
			
			/**
			 * This Method is used to click on product page plus sign
			 * @author hp
			 */
			
			public void clickProductPlusSign()
			{
				plusSignToNavigateProductPage.click();
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