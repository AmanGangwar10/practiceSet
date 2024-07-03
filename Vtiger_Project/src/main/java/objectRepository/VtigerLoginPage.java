package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {

	//initialization
	public VtigerLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(name ="user_name")
	private WebElement userTextField;
	
	@FindBy(name ="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id ="submitButton")
	private WebElement loginButton;

	//getterMethods
	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
		//Business logics
		/**
		 * this methods is used to launch the application
		 * @param userName
		 * @param passWord
		 * @author hp
		 */
	
		public void loginToApp(String userName, String passWord)
		{
			userTextField.sendKeys(userName);
			passwordTextField.sendKeys(passWord);
			loginButton.click();
		}
		
}