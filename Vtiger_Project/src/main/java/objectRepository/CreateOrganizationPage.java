package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generric_Utilities.WebDriver_Utility;

public class CreateOrganizationPage {

	//initialization
	public CreateOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement organizationPlusSign;
	
	@FindBy(name = "accountname")
	private WebElement organizationName;
	
	@FindBy(name = "phone")
	private WebElement organizationPhoneNum;
	
	@FindBy(name = "email1")
	private WebElement organizationEmailId;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	//getterMethods
	public WebElement getCreateOrganizationImg() {
		return organizationPlusSign;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getOrganizationphoneNum() {
		return organizationPhoneNum;
	}

	public WebElement getOrganizationemailID() {
		return organizationEmailId;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}	
	
	//Business logics
	
	/**
	 * This method is used to click on + sign
	 * @author hp
	 */
	
	public void ClickOrgPlusSign()
	{
		organizationPlusSign.click();
	}
	
	/**
	 * This method is used to enter organization name
	 * @param OrgName
	 * @author hp
	 */

	public void enterOrgName(String OrgName)
	{
		organizationName.sendKeys(OrgName);
	}
	
	/**
	 * This method is used to enter organization phoneNum
	 * @param phoneNum
	 * @author hp
	 */
	
	public void enterOrgPhoneNum(String PhoneNum)
	{
		organizationPhoneNum.sendKeys(PhoneNum);
	}
	
	/**
	 * This method is used to enter organization email
	 * @param Email
	 * @author hp
	 */
	
	public void enterOrgEmail(String Email)
	{
		organizationEmailId.sendKeys(Email);
	}
	
	/**
	 * This method is used to enter organization data
	 * @param OrgName
	 * @param phoneNum
	 * @param Email
	 * @author hp
	 */
	
	public void orgData(String OrgName,String phoneNum,String Email)
	{
		organizationName.sendKeys(OrgName);
		organizationPhoneNum.sendKeys(phoneNum);
		organizationEmailId.sendKeys(Email);
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