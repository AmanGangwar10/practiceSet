package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePrdValidationPage {

	        //initialization
	
			public DeletePrdValidationPage(WebDriver driver) 
			{
				PageFactory.initElements(driver, this);
			}
			
			//Declaration

			@FindBy(xpath = "//input[@value='Delete']")
			private WebElement deleteButton;
			
			//Business logics

			/**
			 * this method is used to write the dynamic xpath
			 * @param driver
			 * @param productData
			 * @author hp
			 */
			public void deleteProduct(WebDriver driver,String productData )
			{
				 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
			}
			
			/**
			 * this method is used to click on delete button
			 * @author hp
			 */
			public void clickOnDeleteButton()
			{
				deleteButton.click();
			}
			
			public void validateProductDeleted(WebDriver driver,String productData)
			{
				List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")); 
			   	
			       boolean flag = false;

			       for (WebElement prdName : productList)
			       {
				    String actData = prdName.getText();
				    if(actData.contains(productData))
				     {
					  flag=true;
				      break;
				     }
				    }
			       if(flag)
			        {
				     System.out.println("product data is deleted");
			        }
			      else
			        {
				     System.out.println("product data is not deleted");
			        }
			}
}