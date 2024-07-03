package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generric_Utilities.WebDriver_Utility;

public class HomePage {

	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutImg;
	
	@FindBy(xpath ="//a[text()='Sign Out']")
	private WebElement signOut;
	
	
	//getterMethods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}	
	
	public WebElement getLogOutImg() {
		return logOutImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//Business logics
	
	

	/**
	 * this method is used to click organization link
	 * @author hp
	 */
	
	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	
	/**
	 * this method is used to click product link
	 * @author hp
	 */
	
	public void clickProductLink()
	{
		productLink.click();
	}
	
	/**
	 * this method is used to click more link
	 * @author hp
	 */
	
	public void clickMoreLink() 
	{
	   moreLink.click();	
	}
	
	/**
	 * this method is used to click campaign link
	 * @author hp
	 */
	
	public void clickCampaignsLink() 
	{
	   campaignsLink.click();	
	}
	
	 /**
     * This methos is used to Logout from Application
     * @author hp
     */
	
	public void logOutfromApp()
	{
		logOutImg.click();
		signOut.click();
	}
	
	/**
     * This method is used to Logout from Application(Altervative Approch)
     * @param driver
     * @author hp
     */
	
	public void logOut(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.moveToElement(driver, logOutImg ); 
		signOut.click();
	}
	
}